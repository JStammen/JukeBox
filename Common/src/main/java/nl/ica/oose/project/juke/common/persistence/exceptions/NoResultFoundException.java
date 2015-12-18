package nl.ica.oose.project.juke.common.persistence.exceptions;

import javax.ws.rs.core.Response;

/**
 * This class is the exception to be thrown when a result was expected but not found
 *
 * @author Kayan Meijer
 * @see Exception
 */
public class NoResultFoundException extends Exception {

    private static final String MESSAGE = "No result found.";

    private static final int CODE = Response.Status.NOT_FOUND.getStatusCode();

    /**
     * The empty constructor used to throw this exception.
     */
    public NoResultFoundException() {
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
