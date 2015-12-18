package nl.ica.oose.project.juke.searchservice.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

/**
 * This class Configurates the SearchService. It sets up the database connectiom
 *
 * @author Kayan Meijer
 * @author Jop Stammen
 * @see io.dropwizard.Configuration
 * @see nl.ica.oose.project.juke.common.persistence.IDatabaseConfig
 */
public class SearchServiceConfig extends Configuration implements IDatabaseConfig {

    @JsonProperty
    private String serverlocation;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String driver;

    /**
     * The default constructor for SearchServiceConfig
     */
    public SearchServiceConfig() {

    }

    /**
     * The constructor to instantiate this class
     *
     * @param driver         what database driver is used
     * @param serverlocation on what location it can be found
     * @param username       the username to login
     * @param password       the password to verify your login
     */
    public SearchServiceConfig(String driver, String serverlocation, String username, String password) {
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
