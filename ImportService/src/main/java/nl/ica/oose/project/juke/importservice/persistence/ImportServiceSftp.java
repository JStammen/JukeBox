package nl.ica.oose.project.juke.importservice.persistence;

import com.jcraft.jsch.SftpException;
import nl.ica.oose.project.juke.common.persistence.Sftp;

import java.io.FileInputStream;

/**
 * This class handles all things related to the SSH FTP Server for the service ImportService
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.importservice.persistence.IImportServiceSftp
 * @see nl.ica.oose.project.juke.common.persistence.Sftp
 */
public class ImportServiceSftp extends Sftp implements IImportServiceSftp {

    private String workingdir;
    private String tempdir;

    /**
     * The constructor for the class ImportServiceSftp
     *
     * @param sftpconfig the config file for sftp connection
     */
    public ImportServiceSftp(IImportServiceSftpConfig sftpconfig) {
        super(sftpconfig);
        setWorkingDir(sftpconfig.getWorkingdir());
        setTempDir(sftpconfig.getTempdir());
    }

    /**
     * Method to write files
     *
     * @param fis      inputstream of the uploaded file
     * @param newname  new name of the file
     * @param artistid the id of the artist that made the song
     * @param albumid  the id of the album the song is on
     * @throws com.jcraft.jsch.SftpException
     */
    public void writeFile(FileInputStream fis, String newname, int artistid, int albumid) throws SftpException {
        int depth = 0;
        makeDirectoryAndMove(artistid);
        depth++;

        if (albumid != 0) {
            makeDirectoryAndMove(albumid);
            depth++;
        }

        channelsftp.put(fis, newname);

        for (int i = 0; i < depth; i++) {
            channelsftp.cd("..");
        }
    }

    /**
     * Gets the location where files must be placed in
     *
     * @return the location
     */
    public String getWorkingDir() {
        return workingdir;
    }

    /**
     * Sets the directory where the file must be placed in
     *
     * @param workingdir location where files must be placed in
     */
    public void setWorkingDir(String workingdir) {
        this.workingdir = workingdir;
    }

    /**
     * Get temp directory
     *
     * @return the location of the temp directory
     */
    public String getTempDir() {
        return tempdir;
    }

    /**
     * Sets the location of the temp directory
     *
     * @param tempdir the location of temp directory
     */
    public void setTempDir(String tempdir) {
        this.tempdir = tempdir;
    }

    private void makeDirectoryAndMove(int id) throws SftpException {
        try {
            channelsftp.mkdir(String.valueOf(id));
            channelsftp.cd(String.valueOf(id));
        } catch (SftpException e) {
            channelsftp.cd(String.valueOf(id));
        }
    }
}
