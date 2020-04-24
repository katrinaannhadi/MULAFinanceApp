/* Mula */

package org.mula.finance.core.database;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table
{
    String name();
    String id() default "id";
}
