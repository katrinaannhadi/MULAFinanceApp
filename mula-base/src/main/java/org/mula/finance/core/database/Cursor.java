/* Mula */

package org.mula.finance.core.database;

import androidx.annotation.*;

public interface Cursor extends AutoCloseable
{
    @Override
    void close();

    /**
     * Moves the cursor forward one row from its current position. Returns
     * true if the current position is valid, or false if the cursor is already
     * past the last row. The cursor start at position -1, so this method must
     * be called first.
     */
    boolean moveToNext();

    /**
     * Retrieves the value of the designated column in the current row of this
     * Cursor as an Integer. If the value is null, returns null. The first
     * column has index zero.
     */
    @Nullable
    Integer getInt(int index);

    /**
     * Retrieves the value of the designated column in the current row of this
     * Cursor as a Long. If the value is null, returns null. The first
     * column has index zero.
     */
    @Nullable
    Long getLong(int index);

    /**
     * Retrieves the value of the designated column in the current row of this
     * Cursor as a Double. If the value is null, returns null. The first
     * column has index zero.
     */
    @Nullable
    Double getDouble(int index);

    /**
     * Retrieves the value of the designated column in the current row of this
     * Cursor as a String. If the value is null, returns null. The first
     * column has index zero.
     */
    @Nullable
    String getString(int index);
}
