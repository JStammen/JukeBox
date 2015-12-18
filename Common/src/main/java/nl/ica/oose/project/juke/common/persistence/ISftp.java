package nl.ica.oose.project.juke.common.persistence;

/**
 * The interface for an Sftp class
 *
 * @author Harm Tacoma
 */
public interface ISftp {

    /**
     * Checks if the session is valid and channel is connected.
     *
     * @return isValid() and isConnected()
     */
    public boolean isValid();
}
