package nl.ica.oose.project.juke.playlistgetservice.persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.IDatabase;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface describes the database class for PlaylistGetService
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface IPlaylistGetServicePersistence extends IDatabase {

    /**
     * This method takes a playlistId and gets all tracks in that playlist.
     * This method also gathers all relevant details about those tracks.
     *
     * @param playlistId the id of the playlist
     * @return a list of tracks with relevant details
     * @throws java.sql.SQLException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     */
    public List<Track> getTracks(int playlistId) throws SQLException, NoResultFoundException;

    /**
     * This method checks if a user belongs to a playlist
     *
     * @param userId     the id of the user
     * @param playlistId the id of the playlist
     * @return false when the playlist does not belong to the user, true when it does
     * @throws java.sql.SQLException
     */
    public boolean verifyUser(int userId, int playlistId) throws SQLException;

    /**
     * This method gets the list of playlists belonging to a user
     *
     * @param userId the id of the user
     * @return a list of playlists belonging to the user
     * @throws java.sql.SQLException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     */
    public List<Playlist> getPlaylists(int userId) throws SQLException, NoResultFoundException;

    /**
     * This method gets the userid of the user belonging to the given username
     *
     * @param username the name of the user
     * @return the name of the user in String form
     * @throws SQLException
     * @throws NoResultFoundException
     */
    public int getUserId(String username) throws SQLException, NoResultFoundException;
}
