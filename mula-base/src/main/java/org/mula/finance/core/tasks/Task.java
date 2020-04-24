/* Mula */

package org.mula.finance.core.tasks;

import androidx.annotation.*;

public interface Task
{
    default void cancel() {}

    default boolean isCanceled()
    {
        return false;
    }

    void doInBackground();

    default void onAttached(@NonNull TaskRunner runner) {}

    default void onPostExecute() {}

    default void onPreExecute() {}

    default void onProgressUpdate(int value) {}
}
