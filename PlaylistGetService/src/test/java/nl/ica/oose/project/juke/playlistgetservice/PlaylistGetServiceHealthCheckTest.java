package nl.ica.oose.project.juke.playlistgetservice;

import com.codahale.metrics.health.HealthCheck.Result;
import nl.ica.oose.project.juke.playlistgetservice.Persistence.PlaylistGetServiceDatabaseMock;
import nl.ica.oose.project.juke.playlistgetservice.Persistence.PlaylistGetServiceDatabaseMockUnhealthy;
import org.junit.Test;

import static junit.framework.Assert.*;

public class PlaylistGetServiceHealthCheckTest {

    @Test
    public void createNewPlaylistGetServiceHealthCheckShouldNotFail() {
        assertNotNull(new PlaylistGetServiceHealthCheck(new PlaylistGetServiceDatabaseMock()));
    }

    @Test(expected = NullPointerException.class)
    public void insertANull() {
        new PlaylistGetServiceHealthCheck(null);
    }

    @Test
    public void insertANullResponse() {
        try {
            new PlaylistGetServiceHealthCheck(null);
        } catch (NullPointerException e) {
            assertEquals("Database argument was null.", e.getMessage());
        }
    }

    @Test
    public void healthyExpected() throws Exception {
        PlaylistGetServiceHealthCheck healthcheck = new PlaylistGetServiceHealthCheck(new PlaylistGetServiceDatabaseMock());
        Result result = healthcheck.check();
        assertTrue(result.isHealthy());
    }

    @Test
    public void unhealthyExpected() throws Exception {
        PlaylistGetServiceHealthCheck healthCheck = new PlaylistGetServiceHealthCheck(new PlaylistGetServiceDatabaseMockUnhealthy());
        Result result = healthCheck.check();
        assertFalse(result.isHealthy());
    }
}
