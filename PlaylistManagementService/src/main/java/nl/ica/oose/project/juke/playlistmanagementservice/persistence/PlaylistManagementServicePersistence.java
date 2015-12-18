package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import nl.ica.oose.project.juke.common.persistence.Database;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class that handles all the request for the database.
 *
 * @author Harm Tacoma
 * @author Paul Kamps
 * @author Kayan Meijer
 */
public class PlaylistManagementServicePersistence extends Database implements IPlaylistManagementServicePersistence {

    /**
     * The constructor to create a new instance of the PlaylistManagementServicePersistence
     *
     * @param config The used configuration for the Database
     * @throws ClassNotFoundException can be thrown
     * @throws java.sql.SQLException  can be thrown
     */
    public PlaylistManagementServicePersistence(IDatabaseConfig config) throws ClassNotFoundException, SQLException {
        super(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPlaylist(String playlistName, String userName) throws SQLException {
        int userID = getUserIDFromUserName(userName);
        statement.executeUpdate(getInsertPlaylistQuery(playlistName, userID));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePlaylist(int playlistID) throws SQLException {
        statement.executeUpdate(getDeletePlaylistQuery(playlistID));
    }

    private int getUserIDFromUserName(String userName) throws SQLException {
        ResultSet resultSet = statement.executeQuery(getUserIDFromNameQuery(userName));

        int userID = 0;
        while (resultSet.next()) {
            userID = resultSet.getInt("userID");
        }
        return userID;
    }

    private String getInsertPlaylistQuery(String name, int id) {
        return "INSERT INTO playlist (name, userID) VALUES ('" + name + "'," + id + ")";
    }

    private String getDeletePlaylistQuery(int id) {
        return "DELETE FROM playlist WHERE playlistID = " + id;
    }

    private String getUserIDFromNameQuery(String userName) {
        return "SELECT * FROM user WHERE name LIKE '" + userName + "'";
    }
}
