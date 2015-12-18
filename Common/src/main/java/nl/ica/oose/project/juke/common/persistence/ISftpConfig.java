package nl.ica.oose.project.juke.common.persistence;

/**
 * This interface describes a class to be used for configurating an Sftp class
 *
 * @author Harm Tacoma
 */
public interface ISftpConfig {

    /**
     * basic getter for Sftphost
     *
     * @return the host address of the sftp server
     */
    public String getSftphost();

    /**
     * basic setter for Sftphost
     *
     * @param sftphost the host address of the sftp server
     */
    public void setSftphost(String sftphost);

    /**
     * basic getter for sftpport
     *
     * @return the port used for connecting with the sftp server
     */
    public int getSftpport();

    /**
     * basic setter for sftpport
     *
     * @param sftpport the port used for connecting with the sftp server
     */
    public void setSftpport(int sftpport);

    /**
     * basic getter for sftpuser
     *
     * @return the user account on the sftp server
     */
    public String getSftpuser();

    /**
     * basic setter for sftpuser
     *
     * @param sftpuser the user account on the sftp server
     */
    public void setSftpuser(String sftpuser);

    /**
     * basic getter for sftppass
     *
     * @return the password belonging to the user account on the sftp server
     */
    public String getSftppass();

    /**
     * basic setter for sftppass
     *
     * @param sftppass the password belonging to the user account on the sftp server
     */
    public void setSftppass(String sftppass);

    /**
     * basic getter for workingdir
     *
     * @return the directory that is being used on the ftp server within the http server
     */
    public String getWorkingdir();

    /**
     * basic setter for workingdir
     *
     * @param sftpworkingdir the directory that is being used on the ftp server within the http server
     */
    public void setWorkingdir(String sftpworkingdir);

    /**
     * basic getter for httpserverdir
     *
     * @return the directory of the http server on the ftp server
     */
    public String getHttpserverdir();

    /**
     * basic setter for httpserverdir
     *
     * @param httpserverdir the directory of the http server on the ftp server
     */
    public void setHttpserverdir(String httpserverdir);
}
