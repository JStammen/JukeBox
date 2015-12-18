package nl.ica.oose.project.juke.common.domain;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;

/**
 * This class is the representation of a playlist
 *
 * @author Harm Tacoma
 */
@Entity
public class Playlist {

    @Column(name = "playlistID")
    private int playlistID;
    @Column(name = "name")
    private String name;
    @Column(name = "userID")
    private int userID;

    /**
     * The  basic constructor for the entity Playlist
     */
    public Playlist() {

    }

    /**
     * The constructor for the playlist entity
     *
     * @param playlistID the id of the playlist
     * @param name       the name of the playlist
     * @param userID     the id of the user that owns the playlist
     */
    public Playlist(int playlistID, String name, int userID) {
        setPlaylistID(playlistID);
        setName(name);
        setUserID(userID);
    }


    /**
     * gets the playlistID
     *
     * @return the playlistID of the playlist
     */
    public int getPlaylistID() {
        return playlistID;
    }

    /**
     * sets the playlistID
     *
     * @param playlistID the playlistID of the playlist
     */
    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    /**
     * gets the name of the playlist
     *
     * @return the name of the playlist
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the playlist
     *
     * @param name the name of the playlist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the userID of the user that owns the database
     *
     * @return the userID of the user that owns the database
     */
    public int getUserID() {
        return userID;
    }

    /**
     * sets the userID of the user that owns the database
     *
     * @param userID the userID of the user that owns the database
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

}
