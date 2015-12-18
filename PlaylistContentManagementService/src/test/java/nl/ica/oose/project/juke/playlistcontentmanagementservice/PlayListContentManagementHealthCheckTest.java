package nl.ica.oose.project.juke.playlistcontentmanagementservice;

import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.H2Config;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.PlayListContentManagementServicePersistence;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.PlayListContentManagementServicePersistenceMockUnhealthy;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class PlayListContentManagementHealthCheckTest {

    @Test
    public void createNewRateTrackServiceHealthCheckShouldNotFail() throws SQLException, ClassNotFoundException {
        assertNotNull(new PlayListContentManagementServiceHealthCheck(new PlayListContentManagementServicePersistence(new H2Config())));
    }

    @Test(expected = NullPointerException.class)
    public void createNewRateTrackServiceHealthCheckShouldFailWhenArgumentIsNull() {
        new PlayListContentManagementServiceHealthCheck(null);
    }

    @Test
    public void checkShouldNotFail() throws Exception {
        PlayListContentManagementServiceHealthCheck healthCheck = new PlayListContentManagementServiceHealthCheck(new PlayListContentManagementServicePersistence(new H2Config()));
        assertTrue(healthCheck.check().isHealthy());
    }

    @Test
    public void checkShouldFail() throws Exception {
        PlayListContentManagementServiceHealthCheck healthCheck = new PlayListContentManagementServiceHealthCheck(new PlayListContentManagementServicePersistenceMockUnhealthy());
        assertFalse(healthCheck.check().isHealthy());
    }
}
