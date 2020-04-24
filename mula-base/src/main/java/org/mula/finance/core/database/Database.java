/* Mula */

package org.mula.finance.core.database;

import java.util.*;

public interface Database
{
    Cursor query(String query, String... params);

    default void query(String query, ProcessCallback callback)
    {
        try (Cursor c = query(query)) {
            c.moveToNext();
            callback.process(c);
        }
    }

    int update(String tableName,
               Map<String, Object> values,
               String where,
               String... params);

    Long insert(String tableName, Map<String, Object> values);

    void delete(String tableName, String where, String... params);

    void execute(String query, Object... params);

    void beginTransaction();

    void setTransactionSuccessful();

    void endTransaction();

    void close();

    int getVersion();

    interface ProcessCallback
    {
        void process(Cursor cursor);
    }
}
