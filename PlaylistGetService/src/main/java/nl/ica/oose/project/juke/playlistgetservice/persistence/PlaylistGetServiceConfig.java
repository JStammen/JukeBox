package nl.ica.oose.project.juke.playlistgetservice.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

/**
 * The configuration class for the service PlaylistGetService. This sets up the database connection
 *
 * @author Harm Tacoma
 * @see io.dropwizard.Configuration
 * @see nl.ica.oose.project.juke.common.persistence.IDatabaseConfig
 */
public class PlaylistGetServiceConfig extends Configuration implements IDatabaseConfig {

    //database
    @JsonProperty
    private String serverlocation;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String driver;

    /**
     * The default constructor for PlaylistGetServiceConfig
     */
    public PlaylistGetServiceConfig() {
    }

    /**
     * The constructor for the PlaylistGetServiceConfig
     *
     * @param serverlocation the serverlocation
     * @param username       the username
     * @param password       the password
     * @param driver         the driver
     */
    public PlaylistGetServiceConfig(String serverlocation, String username, String password, String driver) {
        setServerlocation(serverlocation);
        setUsername(username);
        setPassword(password);
        setDriver(driver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getServerlocation() {
        return serverlocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setServerlocation(String serverlocation) {
        this.serverlocation = serverlocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDriver() {
        return driver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
