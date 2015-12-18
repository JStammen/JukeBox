package nl.ica.oose.project.juke.common.persistence.exceptions;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static junit.framework.Assert.assertEquals;

public class NoResultFoundExceptionTest {

    private static final String MESSAGE = "No result found.";
    private static final int CODE = Response.Status.NOT_FOUND.getStatusCode();

    private NoResultFoundException noResultFoundException;

    @Before
    public void startUp() {
        this.noResultFoundException = new NoResultFoundException();
    }

    @Test
    public void getCodeShouldReturnNotFoundStatusCode() {
        assertEquals(noResultFoundException.getCode(), CODE);
    }

    @Test
    public void getMessageShouldReturnDefaultMessage() {
        assertEquals(noResultFoundException.getMessage(), MESSAGE);
    }
}
