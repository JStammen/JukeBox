package nl.ica.oose.project.juke.common.persistence.exceptions;

import javax.ws.rs.core.Response;

/**
 * This class is an Exception to be thrown in cases where an Entity annotation was expected but not found
 *
 * @author Kayan Meijer
 * @see Exception
 */
public class EntityAnnotationNotFoundException extends Exception {

    private static final String MESSAGE = "Entity Annotation was not found.";

    private static final int CODE = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

    /**
     * The empty constructor used to throw this exception.
     */
    public EntityAnnotationNotFoundException() {
    }

    /**
     * Gets the error code.
     *
     * @return code
     */
    public int getCode() {
        return this.CODE;
    }

    /**
     * Gets the error message.
     *
     * @return message.
     */
    public String getMessage() {
        return this.MESSAGE;
    }
}
