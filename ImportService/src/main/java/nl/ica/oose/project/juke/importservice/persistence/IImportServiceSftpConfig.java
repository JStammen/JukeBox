package nl.ica.oose.project.juke.importservice.persistence;

import nl.ica.oose.project.juke.common.persistence.ISftpConfig;

/**
 * The interface for the configuration for ImportServiceSftp
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.ISftpConfig
 */
public interface IImportServiceSftpConfig extends ISftpConfig {

    /**
     * Setter for tempdir
     *
     * @param tempdir the temporary directory for files
     */
    public void setTempdir(String tempdir);

    /**
     * Getter for tempdir
     *
     * @return returns the temporary directory for files
     */
    public String getTempdir();
}
