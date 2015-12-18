package nl.ica.oose.project.juke.common.domain;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;

/**
 * This class is the representation of a tracklocation
 *
 * @author Rik Palm
 */
@Entity
public class TrackLocation {

    @Column(name = "trackID")
    private int trackID;
    @Column(name = "path")
    private String path;

    /**
     * The empty constructor used for mapping ResultSet to a Track.
     */
    public TrackLocation() {

    }

    /**
     * The constructor used to create a new TrackLocation.
     *
     * @param trackID The id of the track.
     * @param path    The path of the track.
     */
    public TrackLocation(int trackID, String path) {
        this.trackID = trackID;
        this.path = path;
    }

    /**
     * Gets the path.
     *
     * @return path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the trackID.
     *
     * @return trackid.
     */
    public int getTrackID() {
        return trackID;
    }
}