/* Mula */

package org.mula.finance.core.database;

import androidx.annotation.*;

import java.io.*;

public interface DatabaseOpener
{
    Database open(@NonNull File file);
}
