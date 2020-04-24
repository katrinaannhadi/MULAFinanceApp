/* Mula */

package org.mula.finance.core.database;

import org.apache.commons.lang3.*;

import java.sql.*;
import java.util.*;

public class JdbcDatabase implements Database
{
    private Connection connection;

    private boolean transactionSuccessful;

    public JdbcDatabase(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Cursor query(String query, String... params)
    {
        try
        {
            PreparedStatement st = buildStatement(query, params);
            return new JdbcCursor(st.executeQuery());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(String tableName,
                      Map<String, Object> map,
                      String where,
                      String... params)
    {
        try
        {
            ArrayList<String> fields = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();

            for (Map.Entry<String, Object> entry : map.entrySet())
            {
                if (entry.getValue() == null) continue;
                fields.add(entry.getKey() + "=?");
                values.add(entry.getValue().toString());
            }
            values.addAll(Arrays.asList(params));

            String query = String.format("update %s set %s where %s", tableName,
                StringUtils.join(fields, ", "), where);

            PreparedStatement st = buildStatement(query, values.toArray());
            return st.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long insert(String tableName, Map<String, Object> map)
    {
        try
        {
            ArrayList<String> fields = new ArrayList<>();
            ArrayList<Object> params = new ArrayList<>();
            ArrayList<String> questionMarks = new ArrayList<>();

            for (Map.Entry<String, Object> entry : map.entrySet())
            {
                if (entry.getValue() == null) continue;
                fields.add(entry.getKey());
                params.add(entry.getValue());
                questionMarks.add("?");
            }

            String query =
                String.format("insert into %s(%s) values(%s)", tableName,
                    StringUtils.join(fields, ", "),
                    StringUtils.join(questionMarks, ", "));

            PreparedStatement st = buildStatement(query, params.toArray());
            st.execute();

            Long id = null;
            ResultSet keys = st.getGeneratedKeys();
            if (keys.next()) id = keys.getLong(1);
            return id;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String tableName, String where, String... params)
    {
        String query =
            String.format("delete from %s where %s", tableName, where);
        execute(query, (Object[]) params);
    }

    @Override
    public void execute(String query, Object... params)
    {
        try
        {
            buildStatement(query, params).execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement buildStatement(String query, Object[] params)
        throws SQLException
    {
        PreparedStatement st = connection.prepareStatement(query);
        int index = 1;
        for (Object param : params) st.setString(index++, param.toString());
        return st;
    }

    @Override
    public synchronized void beginTransaction()
    {
        try
        {
            connection.setAutoCommit(false);
            transactionSuccessful = false;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void setTransactionSuccessful()
    {
        transactionSuccessful = true;
    }

    @Override
    public synchronized void endTransaction()
    {
        try
        {
            if (transactionSuccessful) connection.commit();
            else connection.rollback();
            connection.setAutoCommit(true);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getVersion()
    {
        try (Cursor c = query("PRAGMA user_version"))
        {
            c.moveToNext();
            return c.getInt(0);
        }
    }
}
