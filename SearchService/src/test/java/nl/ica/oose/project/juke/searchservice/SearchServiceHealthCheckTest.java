package nl.ica.oose.project.juke.searchservice;

import nl.ica.oose.project.juke.searchservice.persistence.SearchServiceDatabaseMock;
import nl.ica.oose.project.juke.searchservice.persistence.SearchServiceDatabaseMockUnhealthy;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchServiceHealthCheckTest {

    @Test
    public void createNewSearchServiceHealthCheckShouldNotFail() {
        assertNotNull(new SearchServiceHealthCheck(new SearchServiceDatabaseMock()));
    }

    @Test(expected = NullPointerException.class)
    public void createNewSearchServiceHealthCheckShouldFailWhenArgumentIsNull() {
        new SearchServiceHealthCheck(null);
    }

    @Test
    public void testCheck() throws Exception {
        SearchServiceHealthCheck healthcheck = new SearchServiceHealthCheck(new SearchServiceDatabaseMock());
        assertTrue(healthcheck.check().isHealthy());
    }

    @Test
    public void testCheckUnhealthy() throws Exception {
        SearchServiceHealthCheck healthCheck = new SearchServiceHealthCheck(new SearchServiceDatabaseMockUnhealthy());
        assertFalse(healthCheck.check().isHealthy());
    }
}
