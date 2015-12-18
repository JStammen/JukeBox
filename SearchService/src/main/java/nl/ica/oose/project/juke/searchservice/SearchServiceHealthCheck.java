package nl.ica.oose.project.juke.searchservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.searchservice.persistence.ISearchServicePersistence;

/**
 * A class responsible for the healthcheck of this application
 *
 * @author Kayan Meijer
 * @see com.codahale.metrics.health.HealthCheck
 */
public class SearchServiceHealthCheck extends HealthCheck {

    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String CONNECTIONTIMEDOUT = "Connection to the database timed out.";

    private ISearchServicePersistence database;

    /**
     * A constructor to instantiate this class
     *
     * @param database
     */
    public SearchServiceHealthCheck(ISearchServicePersistence database) {
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
