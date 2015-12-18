package nl.ica.oose.project.juke.importservice;

import com.jcraft.jsch.SftpException;
import nl.ica.oose.project.juke.importservice.persistence.IImportServiceSftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This TrackPlacer can place files on a SSH FTP server
 *
 * @author Harm Tacoma
 * @author Robbert de Wilde
 * @author Paul Kamps
 * @see nl.ica.oose.project.juke.importservice.AbstractTrackPlacer
 */
public class ServerTrackPlacer extends AbstractTrackPlacer {
    private IImportServiceSftp sftp;

    /**
     * Constructor for the ServerTrackPlacer. Initializes the Sftp
     *
     * @param sftp importservice sftp
     */
    public ServerTrackPlacer(IImportServiceSftp sftp) {
        this.sftp = sftp;
    }

    /**
     * {@inheritDoc}
     */
    public String placeFile(File file, int trackid, int artistid, int albumid) throws FileNotFoundException, SftpException {
        placeFileOnServer(file, getNewName(file, trackid), artistid, albumid);
        return getNewLocation(file, trackid, artistid, albumid);
    }

    //todo write seperate function without albumid instead of checking for 0
    //todo prevent overwriting files
    private String placeFileOnServer(File file, String newname, int artistid, int albumid) throws FileNotFoundException, SftpException {
        File f = new File(file.toURI());
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            sftp.writeFile(fis, newname, artistid, albumid);
            return sftp.getWorkingDir() + newname;
        } else {
            throw new FileNotFoundException();
        }
    }

    private String getNewName(File file, int trackid) {
        return trackid + file.toString().substring(file.toString().lastIndexOf("."));
    }

    private String getNewLocation(File file, int trackid, int artistid, int albumid) {
        if (albumid == 0)
            return sftp.getWorkingDir() + "/" + artistid + "/" + trackid + file.toString().substring(file.toString().lastIndexOf("."));
        else
            return sftp.getWorkingDir() + "/" + artistid + "/" + albumid + "/" + trackid + file.toString().substring(file.toString().lastIndexOf("."));
    }

}
