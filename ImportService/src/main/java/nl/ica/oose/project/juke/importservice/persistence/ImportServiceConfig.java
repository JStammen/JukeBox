package nl.ica.oose.project.juke.importservice.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

/**
 * The configuration for ImportService. This sets up database and sftp, as well as used directories for file placement
 *
 * @author Harm Tacoma
 * @see io.dropwizard.Configuration
 * @see nl.ica.oose.project.juke.importservice.persistence.IImportServiceSftpConfig
 * @see nl.ica.oose.project.juke.common.persistence.IDatabaseConfig
 */
public class ImportServiceConfig extends Configuration implements IImportServiceSftpConfig, IDatabaseConfig {

    //database
    @JsonProperty
    private String serverlocation;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String driver;

    //sftp
    @JsonProperty
    private String sftphost;
    @JsonProperty
    private int sftpport;
    @JsonProperty
    private String sftpuser;
    @JsonProperty
    private String sftppass;

    //directories used for file placement
    @JsonProperty
    private String workingdir;
    @JsonProperty
    private String tempdir;
    @JsonProperty
    private String httpserverdir;

    public ImportServiceConfig() {

    }

    /**
     * The constructor for the ImportServiceConfig
     *
     * @param serverlocation the serverlocation
     * @param username       the username
     * @param password       the password
     * @param driver         the driver
     * @param sftphost       the sftphost
     * @param sftpport       the sftpport
     * @param sftpuser       the sftpuser
     * @param sftppass       the sftppass
     * @param workingdir     the workingdir
     * @param tempdir        the tempdir
     * @param httpserverdir  the httpserverdir
     */
    public ImportServiceConfig(String serverlocation, String username, String password, String driver, String sftphost, int sftpport, String sftpuser, String sftppass, String workingdir, String tempdir, String httpserverdir) {
        setDriver(driver);
        setPassword(password);
        setServerlocation(serverlocation);
        setSftphost(sftphost);
        setSftppass(sftppass);
        setSftpport(sftpport);
        setTempdir(tempdir);
        setWorkingdir(workingdir);
        setSftpuser(sftpuser);
        setUsername(username);
        setHttpserverdir(httpserverdir);
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

    /**
     * {@inheritDoc}
     */
    public String getSftphost() {
        return sftphost;
    }

    /**
     * {@inheritDoc}
     */
    public void setSftphost(String sftphost) {
        this.sftphost = sftphost;
    }

    /**
     * {@inheritDoc}
     */
    public int getSftpport() {
        return sftpport;
    }

    /**
     * {@inheritDoc}
     */
    public void setSftpport(int sftpport) {
        this.sftpport = sftpport;
    }

    /**
     * {@inheritDoc}
     */
    public String getSftpuser() {
        return sftpuser;
    }

    /**
     * {@inheritDoc}
     */
    public void setSftpuser(String sftpuser) {
        this.sftpuser = sftpuser;
    }

    /**
     * {@inheritDoc}
     */
    public String getSftppass() {
        return sftppass;
    }

    /**
     * {@inheritDoc}
     */
    public void setSftppass(String sftppass) {
        this.sftppass = sftppass;
    }

    /**
     * {@inheritDoc}
     */
    public String getWorkingdir() {
        return workingdir;
    }

    /**
     * {@inheritDoc}
     */
    public void setWorkingdir(String workingdir) {
        this.workingdir = workingdir;
    }

    /**
     * {@inheritDoc}
     */
    public String getTempdir() {
        return tempdir;
    }

    /**
     * {@inheritDoc}
     */
    public void setTempdir(String tempdir) {
        this.tempdir = tempdir;
    }

    /**
     * {@inheritDoc}
     */
    public String getHttpserverdir() {
        return httpserverdir;
    }

    /**
     * {@inheritDoc}
     */
    public void setHttpserverdir(String httpserverdir) {
        this.httpserverdir = httpserverdir;
    }

}
