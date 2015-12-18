package nl.ica.oose.project.juke.importservice;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * This abstract class defines what a TrackPlacer should have in order to be a usable TrackPlacer
 *
 * @author Harm Tacoma
 */
abstract class AbstractTrackPlacer {

    /**
     * The basic constructor of AbstractTrackPlacer
     */
    public AbstractTrackPlacer() {
    }

    /**
     * This function is called by the class that uses the TrackPlacer and is responsible for the actual file placement
     *
     * @param file     the file that needs to be placed into the file system
     * @param trackid  the id of the track in the database, used to determine new file name
     * @param artistid the id of the artist in the database, used for folder structure
     * @param albumid  the id of the album in the database, used for folder structure
     * @return a string representation of the location where the trackfile was placed
     * @throws java.io.IOException           can be thrown
     * @throws com.jcraft.jsch.SftpException can be thrown
     * @throws com.jcraft.jsch.JSchException can be thrown
     */
    public abstract String placeFile(File file, int trackid, int artistid, int albumid) throws IOException, SftpException, JSchException;

    protected String decodeUrl(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, "UTF-8");
    }
}
