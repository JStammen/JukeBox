package nl.ica.oose.project.juke.rateservice;

import nl.ica.oose.project.juke.rateservice.persistence.RateServiceDatabaseMock;
import nl.ica.oose.project.juke.rateservice.persistence.RateServiceDatabaseMockUnhealthy;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class RateServiceHealthCheckTest {

    @Test
    public void createNewRateTrackServiceHealthCheckShouldNotFail() throws SQLException, ClassNotFoundException {
        assertNotNull(new RateServiceHealthCheck(new RateServiceDatabaseMock()));
    }

    @Test(expected = NullPointerException.class)
    public void createNewRateTrackServiceHealthCheckShouldFailWhenArgumentIsNull() {
        new RateServiceHealthCheck(null);
    }

    @Test
    public void testCheck() throws Exception {
        RateServiceHealthCheck healthCheck = new RateServiceHealthCheck(new RateServiceDatabaseMock());
        assertTrue(healthCheck.check().isHealthy());
    }

    @Test
    public void testCheckUnhealthy() throws Exception {
        RateServiceHealthCheck healthCheck = new RateServiceHealthCheck(new RateServiceDatabaseMockUnhealthy());
        assertFalse(healthCheck.check().isHealthy());
    }
}
