/* Mula */

package org.mula.finance.core.database;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Column
{
    String name() default "";
}
