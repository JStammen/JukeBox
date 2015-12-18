package nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabase;

import java.sql.SQLException;


/**
 * This interface describes what the Database class for PlaylistContentManagementService should be able to do
 *
 * @author Jop Stammen
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface IPlayListContentManagementServicePersistence extends IDatabase {

    /**
     * @param playlistID the playlist that needs tracks deleted
     * @param trackID    the track that needs to be deleted
     * @throws java.sql.SQLException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     */
    public boolean deleteTrackOnPlaylist(int playlistID, int trackID) throws SQLException;

    /**
     * @param playlistID the playlist that needs tracks added
     * @param trackID    the track that needs to be added
     * @throws java.sql.SQLException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     */
    public void addTrackOnPlaylist(int playlistID, int trackID) throws SQLException;
}
