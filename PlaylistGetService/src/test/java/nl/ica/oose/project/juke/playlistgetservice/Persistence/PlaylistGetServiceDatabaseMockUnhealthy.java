package nl.ica.oose.project.juke.playlistgetservice.Persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaylistGetServiceDatabaseMockUnhealthy implements IPlaylistGetServicePersistence {
    @Override
    public List<Track> getTracks(int playlistId) throws SQLException, NoResultFoundException {
        throw new NotImplementedException();
    }

    @Override
    public boolean verifyUser(int userId, int playlistId) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public List<Playlist> getPlaylists(int userId) throws SQLException, NoResultFoundException {
        throw new NotImplementedException();
    }

    @Override
    public int getUserId(String username) throws SQLException, NoResultFoundException {
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
