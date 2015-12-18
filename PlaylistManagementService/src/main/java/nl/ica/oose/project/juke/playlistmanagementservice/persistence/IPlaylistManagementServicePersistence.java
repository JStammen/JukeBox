package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabase;

import java.sql.SQLException;

/**
 * This interface describes what the Persistence layer for PlaylistManagementService should be able to do.
 *
 * @author Paul Kamps
 * @author Kayan Meijer
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface IPlaylistManagementServicePersistence extends IDatabase {

    /**
     * This method used to create a new playlist.
     *
     * @param playlistName The name of the new playlist.
     * @param userName     The name of the user who creates the playlist.
     * @throws java.sql.SQLException
     */
    public void createPlaylist(String playlistName, String userName) throws SQLException;

    /**
     * This method is used to deleta a playlist.
     *
     * @param playlistID The id of the playlist.
     * @throws java.sql.SQLException
     */
    public void deletePlaylist(int playlistID) throws SQLException;
}
