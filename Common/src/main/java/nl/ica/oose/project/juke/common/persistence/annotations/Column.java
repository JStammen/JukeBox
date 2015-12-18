package nl.ica.oose.project.juke.common.persistence.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines if a property is a column in SQL.
 * Documentation: http://oprsteny.com/?p=900
 *
 * @author Kayan Meijer
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    /**
     * This method does something with name//todo clarify
     *
     * @return the name, default is ""
     */
    String name() default "";
}
