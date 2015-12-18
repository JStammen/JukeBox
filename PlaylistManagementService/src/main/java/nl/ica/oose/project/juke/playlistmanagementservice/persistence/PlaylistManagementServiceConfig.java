package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

/**
 * This class is the configuration for the PlaylistManagementService.
 * This class contains information about the database connection.
 *
 * @author Paul Kamps
 * @author Kayan Meijer
 * @see io.dropwizard.Configuration
 * @see nl.ica.oose.project.juke.common.persistence.IDatabaseConfig
 */
public class PlaylistManagementServiceConfig extends Configuration implements IDatabaseConfig {

    @JsonProperty
    private String serverlocation;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String driver;

    /**
     * The default constructor for PlaylistManagementServiceConfig
     */
    public PlaylistManagementServiceConfig() {

    }

    /**
     * The constructor used to instantiate this class.
     *
     * @param serverlocation on what location it can be found.
     * @param username       the username to login.
     * @param password       the password to verify your login.
     * @param driver         what database driver is used.
     */
    public PlaylistManagementServiceConfig(String serverlocation, String username, String password, String driver) {
        this.serverlocation = serverlocation;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getServerlocation() {
        return this.serverlocation;
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
        return this.username;
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
        return this.password;
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
        return this.driver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
