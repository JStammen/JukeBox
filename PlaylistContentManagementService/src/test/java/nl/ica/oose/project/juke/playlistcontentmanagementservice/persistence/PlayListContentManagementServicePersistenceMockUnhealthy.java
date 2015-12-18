package nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;

public class PlayListContentManagementServicePersistenceMockUnhealthy implements IPlayListContentManagementServicePersistence {


    @Override
    public boolean isValid() throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public void addTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        throw new NotImplementedException();
    }
}
