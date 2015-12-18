package nl.ica.oose.project.juke.common.domain;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;

/**
 * This class is the representation of an album
 *
 * @author Kayan Meijer
 */
@Entity
public class Album {

    @Column(name = "albumID")
    private int albumID;
    @Column(name = "albumname")
    private String name;

    /**
     * The empty constructor used for mapping ResultSet to a Album.
     */
    public Album() {

    }

    /**
     * The constructor used to create a new album.
     *
     * @param albumID The id of the album.
     * @param name    The name of the album.
     */
    public Album(int albumID, String name) {
        this.albumID = albumID;
        this.name = name;
    }

    /**
     * Gets the name of the album.
     *
     * @return albumname
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the album.
     *
     * @param name The name of the album.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the id of the album.
     *
     * @return albumID
     */
    public int getAlbumID() {
        return albumID;
    }

    /**
     * Sets the id of the album
     *
     * @param albumID The ID of the album.
     */
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
}
