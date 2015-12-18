package nl.ica.oose.project.juke.playlistmanagementservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.IPlaylistManagementServicePersistence;

/**
 * A class responsible for the healthcheck of this application
 *
 * @author Kayan Meijer
 * @see com.codahale.metrics.health.HealthCheck
 */
public class PlaylistManagementHealthCheck extends HealthCheck {

    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String CONNECTIONTIMEDOUT = "Connection to the database timed out.";

    private IPlaylistManagementServicePersistence database;

    /**
     * A constructor to instantiate this class.
     *
     * @param database The database to perform healthchecks on.
     */
    public PlaylistManagementHealthCheck(IPlaylistManagementServicePersistence database) {
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
