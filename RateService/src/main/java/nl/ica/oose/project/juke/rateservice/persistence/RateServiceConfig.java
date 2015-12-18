package nl.ica.oose.project.juke.rateservice.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

/**
 * A class responsible for the database configuration
 *
 * @author Kayan Meijer
 * @see io.dropwizard.Configuration
 * @see nl.ica.oose.project.juke.common.persistence.IDatabaseConfig
 */
public class RateServiceConfig extends Configuration implements IDatabaseConfig {

    @JsonProperty
    private String serverlocation;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String driver;

    /**
     * Constructor for RateTrackServiceConfig
     */
    public RateServiceConfig() {

    }

    /**
     * Method that configures the ratetrackservice
     *
     * @param driver         given drivername
     * @param serverlocation given servername
     * @param username       given username
     * @param password       given password
     */
    public RateServiceConfig(String driver, String serverlocation, String username, String password) {
        this.driver = driver;
        this.serverlocation = serverlocation;
        this.username = username;
        this.password = password;
    }

    /**
     * {@inheritDoc}
     */
    public String getServerlocation() {
        return serverlocation;
    }

    /**
     * {@inheritDoc}
     */
    public void setServerlocation(String serverlocation) {
        this.serverlocation = serverlocation;
    }

    /**
     * {@inheritDoc}
     */
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * {@inheritDoc}
     */
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * {@inheritDoc}
     */
    public String getDriver() {
        return driver;
    }


    /**
     * {@inheritDoc}
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
