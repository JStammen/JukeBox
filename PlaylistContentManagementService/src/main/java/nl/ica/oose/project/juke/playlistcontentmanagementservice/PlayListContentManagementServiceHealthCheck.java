package nl.ica.oose.project.juke.playlistcontentmanagementservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.IPlayListContentManagementServicePersistence;

/**
 * A class responsible for the healthcheck of this application
 *
 * @author Kayan Meijer
 * @see com.codahale.metrics.health.HealthCheck
 */
public class PlayListContentManagementServiceHealthCheck extends HealthCheck {

    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String CONNECTIONTIMEDOUT = "Connection to the database timed out.";

    private IPlayListContentManagementServicePersistence database;

    /**
     * A constructor to instantiate this class
     *
     * @param database
     */
    public PlayListContentManagementServiceHealthCheck(IPlayListContentManagementServicePersistence database) {
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
