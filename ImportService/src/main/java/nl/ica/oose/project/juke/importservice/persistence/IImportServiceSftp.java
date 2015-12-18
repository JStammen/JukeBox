package nl.ica.oose.project.juke.importservice.persistence;

import com.jcraft.jsch.SftpException;
import nl.ica.oose.project.juke.common.persistence.ISftp;

import java.io.FileInputStream;

/**
 * This interface describes what the Sftp class for Import Service should be able to do
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.ISftp
 */
public interface IImportServiceSftp extends ISftp {

    /**
     * Method to write files
     *
     * @param fis      inputstream of the uploaded file
     * @param newname  new name of the file
     * @param artistid the id of the artist that made the song
     * @param albumid  the id of the album the song is on
     * @throws com.jcraft.jsch.SftpException
     */
    public void writeFile(FileInputStream fis, String newname, int artistid, int albumid) throws SftpException;

    /**
     * Gets the workingdir
     *
     * @return the workingdir
     */
    public String getWorkingDir();

    /**
     * sets the workingdir
     *
     * @param workingdir the workingdir
     */
    public void setWorkingDir(String workingdir);

    /**
     * Gets the tempdir
     *
     * @return the tempdir
     */
    public String getTempDir();

    /**
     * set the Tempdir
     *
     * @param tempdir the tempdir
     */
    public void setTempDir(String tempdir);
}
