package nl.ica.oose.project.juke.common.persistence.exceptions;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static junit.framework.Assert.assertEquals;

public class EntityAnnotationNotFoundExceptionTest {
    private static final String MESSAGE = "Entity Annotation was not found.";
    private static final int CODE = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

    private EntityAnnotationNotFoundException entityAnnotationNotFoundException;

    @Before
    public void startUp() {
        this.entityAnnotationNotFoundException = new EntityAnnotationNotFoundException();
    }

    @Test
    public void getCodeShouldReturnNotFoundStatusCode() {
        assertEquals(entityAnnotationNotFoundException.getCode(), CODE);
    }

    @Test
    public void getMessageShouldReturnDefaultMessage() {
        assertEquals(entityAnnotationNotFoundException.getMessage(), MESSAGE);
    }
}
