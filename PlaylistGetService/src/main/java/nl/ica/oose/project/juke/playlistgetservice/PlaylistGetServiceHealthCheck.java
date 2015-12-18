package nl.ica.oose.project.juke.playlistgetservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence;

/**
 * A class responsible for the healthcheck of this application
 *
 * @author Harm Tacoma
 * @see com.codahale.metrics.health.HealthCheck
 */
public class PlaylistGetServiceHealthCheck extends HealthCheck {

    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String CONNECTIONTIMEDOUT = "Connection to the database timed out.";

    private IPlaylistGetServicePersistence database;

    /**
     * A constructor to instantiate this class
     *
     * @param database
     */
    public PlaylistGetServiceHealthCheck(IPlaylistGetServicePersistence database) {
        if (database == null)
            throw new NullPointerException(DATABASEARGUMENTNULLMESSAGE);
        this.database = database;
    }

    @Override
    protected Result check() throws Exception {
        if (!database.isValid())
            return Result.unhealthy(CONNECTIONTIMEDOUT);
        return Result.healthy();
    }
}
