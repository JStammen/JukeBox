package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaylistManagementServicePersistenceMockUnhealthy implements IPlaylistManagementServicePersistence {

    @Override
    public void createPlaylist(String playlistName, String userName) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public void deletePlaylist(int playlistID) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isValid() throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }
}
