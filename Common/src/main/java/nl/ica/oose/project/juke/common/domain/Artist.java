package nl.ica.oose.project.juke.common.domain;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;

/**
 * This class is the representation of an artist
 *
 * @author Kayan Meijer
 */
@Entity
public class Artist {

    @Column(name = "artistID")
    private int artistID;
    @Column(name = "artistName")
    private String artistName;

    /**
     * The empty constructor used for mapping ResultSet to a Artist.
     */
    public Artist() {

    }

    /**
     * The constructor used to create a new artist.
     *
     * @param artistID   The id of the artist.
     * @param artistName The name of the artist.
     */
    public Artist(int artistID, String artistName) {
        setArtistName(artistName);
        setArtistID(artistID);
    }

    /**
     * Gets the name of the artist.
     *
     * @return artistname
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets the name of the artist.
     *
     * @param artistName artisname
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Gets the artist id.
     *
     * @return artistID
     */
    public int getArtistID() {
        return artistID;
    }

    /**
     * Sets the artist id.
     *
     * @param artistID artistid
     */
    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
}
