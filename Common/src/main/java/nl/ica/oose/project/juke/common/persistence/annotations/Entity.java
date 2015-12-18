package nl.ica.oose.project.juke.common.persistence.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines if a class is an Entity in MySQL.
 * Documentation: http://oprsteny.com/?p=900
 *
 * @author Kayan Meijer
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
}
