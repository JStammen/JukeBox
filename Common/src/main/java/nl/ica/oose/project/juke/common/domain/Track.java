package nl.ica.oose.project.juke.common.domain;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;

import java.sql.Time;

/**
 * This class is the representation of a track
 *
 * @author Kayan Meijer
 */
@Entity
public class Track {

    @Column(name = "trackID")
    private int trackID;
    @Column(name = "artistID")
    private int artistID;
    private Artist artist;
    private Album album;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Time duration;

    /**
     * The empty constructor used for mapping ResultSet to a Track.
     */
    public Track() {

    }

    /**
     * The constructor used to create a new Track.
     *
     * @param trackID  The trackid.
     * @param artistID The artistid.
     * @param title    The title of this track.
     * @param duration The duration of this track.
     */
    public Track(int trackID, int artistID, String title, Time duration) {
        this.trackID = trackID;
        this.artistID = artistID;
        this.title = title;
        this.duration = duration;
    }

    /**
     * The constructor used to create a new Track.
     *
     * @param trackID  The trackid.
     * @param artistID The artistid.
     * @param title    The title of this track.
     * @param duration The duration of this track.
     * @param artist   The artist who made this track.
     * @param album    The album.
     */
    public Track(int trackID, int artistID, String title, Time duration, Artist artist, Album album) {
        this.trackID = trackID;
        this.artistID = artistID;
        this.title = title;
        this.duration = duration;

        this.artist = artist;
        this.album = album;
    }

    /**
     * Get the trackid.
     *
     * @return trackid.
     */
    public int getTrackID() {
        return trackID;
    }

    /**
     * Sets the trackid.
     *
     * @param trackID trackid.
     */
    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    /**
     * Gets the duration.
     *
     * @return duration.
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param duration duration.
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }

    /**
     * Gets the title.
     *
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the artist.
     *
     * @return artist.
     */
    public Artist getArtist() {
        return this.artist;
    }

    /**
     * Sets the artist.
     *
     * @param artist artist.
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Gets the artistID.
     *
     * @return artistid.
     */
    public int getArtistID() {
        return artistID;
    }

    /**
     * Gets the album.
     *
     * @return album.
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * Sets the album.
     *
     * @param album album.
     */
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * Sets the artistid.
     *
     * @param artistID artistid.
     */
    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
}
