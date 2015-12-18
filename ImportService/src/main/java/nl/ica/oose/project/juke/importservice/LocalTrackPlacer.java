package nl.ica.oose.project.juke.importservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileAlreadyExistsException;

import static org.apache.commons.io.FileUtils.copyFile;

/**
 * This TrackPlacer is capable of placing a file locally
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.importservice.AbstractTrackPlacer
 */
public class LocalTrackPlacer extends AbstractTrackPlacer {

    /**
     * Constructor of LocalTrackPlace
     */
    public LocalTrackPlacer() {
    }

    /**
     * {@inheritDoc}
     */
    public String placeFile(File file, int trackid, int artistid, int albumid) throws IOException {
        File result = new File(getNewPath(file, trackid, artistid, albumid));
        if (!result.exists() && file.exists()) {
            copyFile(file, result);
        } else if (result.exists()) {
            throw new FileAlreadyExistsException(result.toString());
        } else if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return result.toString();
    }

    private String getNewPath(File file, int trackid, int artistid, int albumid) throws UnsupportedEncodingException {
        String location = this.getClass().getClassLoader().getResource("").getFile() + "musicsystem/imports/";
        location = decodeUrl(location);
        if (albumid == 0) {
            return location + artistid + "/" + trackid + file.toString().substring(file.toString().lastIndexOf("."));
        }
        return location + artistid + "/" + albumid + "/" + trackid + file.toString().substring(file.toString().lastIndexOf("."));
    }
}