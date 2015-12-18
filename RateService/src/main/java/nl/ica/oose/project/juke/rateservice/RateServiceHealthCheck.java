package nl.ica.oose.project.juke.rateservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.rateservice.persistence.IRateServicePersistence;

/**
 * A class responsible for the healthchecks of this application
 *
 * @author Kayan Meijer
 * @see com.codahale.metrics.health.HealthCheck
 */
public class RateServiceHealthCheck extends HealthCheck {

    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String CONNECTIONTIMEDOUT = "Connection to the database timed out.";

    private IRateServicePersistence database;

    /**
     * Constructor for RateTrackServiceHealthCheck
     *
     * @param database contains the database information
     */
    public RateServiceHealthCheck(IRateServicePersistence database) {
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
