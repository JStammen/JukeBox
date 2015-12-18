package nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence;

import nl.ica.oose.project.juke.common.persistence.Database;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

import java.sql.SQLException;


/**
 * The class that handles all the request for the database
 *
 * @author Jop Stammen
 * @see nl.ica.oose.project.juke.common.persistence.Database
 * @see nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.IPlayListContentManagementServicePersistence
 */
public class PlayListContentManagementServicePersistence extends Database implements IPlayListContentManagementServicePersistence {

    /**
     * A constructor to instantiate this class
     *
     * @param config a config class for database connection
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public PlayListContentManagementServicePersistence(IDatabaseConfig config) throws SQLException, ClassNotFoundException {
        super(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        int result = statement.executeUpdate(getDeleteQuery(playlistID, trackID));
        return result == 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        statement.executeUpdate(getAddTrackQuery(playlistID, trackID));
    }

    private String getDeleteQuery(int playlistID, int trackID) {
        return "DELETE FROM trackonplaylist WHERE trackID = " + trackID + " AND playlistID = " + playlistID;
    }

    private String getAddTrackQuery(int playlistId, int trackId) {
        return "INSERT INTO trackonplaylist (playlistID, trackID) VALUES (" + playlistId + "," + trackId + ")";
    }


}