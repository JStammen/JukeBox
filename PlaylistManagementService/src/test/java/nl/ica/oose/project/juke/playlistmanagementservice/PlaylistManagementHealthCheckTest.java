package nl.ica.oose.project.juke.playlistmanagementservice;

import nl.ica.oose.project.juke.playlistmanagementservice.persistence.H2Config;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.PlaylistManagementServicePersistence;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.PlaylistManagementServicePersistenceMockUnhealthy;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class PlaylistManagementHealthCheckTest {

    @Test
    public void createNewRateTrackServiceHealthCheckShouldNotFail() throws SQLException, ClassNotFoundException {
        assertNotNull(new PlaylistManagementHealthCheck(new PlaylistManagementServicePersistence(new H2Config())));
    }

    @Test(expected = NullPointerException.class)
    public void createNewRateTrackServiceHealthCheckShouldFailWhenArgumentIsNull() {
        new PlaylistManagementHealthCheck(null);
    }

    @Test
    public void checkShouldNotFail() throws Exception {
        PlaylistManagementHealthCheck healthCheck = new PlaylistManagementHealthCheck(new PlaylistManagementServicePersistence(new H2Config()));
        assertTrue(healthCheck.check().isHealthy());
    }

    @Test
    public void checkShouldFail() throws Exception {
        PlaylistManagementHealthCheck healthCheck = new PlaylistManagementHealthCheck(new PlaylistManagementServicePersistenceMockUnhealthy());
        assertFalse(healthCheck.check().isHealthy());
    }
}
