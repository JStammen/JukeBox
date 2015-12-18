package nl.ica.oose.project.juke.playlistgetservice.Persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.domain.TrackInPlaylist;
import nl.ica.oose.project.juke.common.domain.User;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PlaylistGetServiceDatabaseMock implements IPlaylistGetServicePersistence {
    List<Playlist> playlists = new ArrayList<>();
    List<Track> tracks = new ArrayList<>();
    List<TrackInPlaylist> tracksInPlaylist = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public PlaylistGetServiceDatabaseMock() {
        initializeLists();
    }

    @Override
    public List<Track> getTracks(int playlistId) throws SQLException, NoResultFoundException {
        List<Track> result = new ArrayList<>();
        for (int i = 0; i < tracksInPlaylist.size(); i++) {
            if (tracksInPlaylist.get(i).getPlaylistId() == playlistId)
                result.add(tracks.get(i));//Superlazy gedaan, tracks en tracksinplaylist moeten hiervoor qua trackid gelijk lopen als het fout gaat
        }
        if (result == null || result.isEmpty())
            throw new NoResultFoundException();
        return result;
    }

    @Override
    public boolean verifyUser(int userId, int playlistId) throws SQLException {
        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);
            if (playlist.getUserID() == userId && playlist.getPlaylistID() == playlistId)
                return true;
        }
        return false;
    }

    @Override
    public List<Playlist> getPlaylists(int userId) throws SQLException, NoResultFoundException {
        List<Playlist> result = new ArrayList<>();
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getUserID() == userId)
                result.add(playlists.get(i));
        }
        if (result == null || result.isEmpty())
            throw new NoResultFoundException();
        return result;
    }

    @Override
    public int getUserId(String username) throws SQLException, NoResultFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equalsIgnoreCase(username))
                return users.get(i).getUserID();
        }
        throw new NoResultFoundException();
    }

    @Override
    public boolean isValid() throws SQLException {
        return true;
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }

    private void initializeLists() {
        createPlaylists();
        createTrackInPlaylists();
        createTracks();
        createUsers();
    }

    private void createUsers() {
        users.add(new User(1, "Harm"));
        users.add(new User(2, "Jobe"));
        users.add(new User(3, "Papaul"));
        users.add(new User(4, "Kayak"));
    }

    private void createPlaylists() {
        playlists.add(new Playlist(1, "naam 1", 1));
        playlists.add(new Playlist(2, "naam 2", 1));
        playlists.add(new Playlist(3, "naam 3", 2));
        playlists.add(new Playlist(4, "naam 4", 2));
    }

    private void createTracks() {
        tracks.add(new Track(1, 1, "TestTrack 1", new Time(123)));
        tracks.add(new Track(2, 2, "TestTrack 2", new Time(123)));
        tracks.add(new Track(3, 3, "TestTrack 3", new Time(123)));
        tracks.add(new Track(4, 4, "TestTrack 4", new Time(123)));
        tracks.add(new Track(5, 5, "TestTrack 5", new Time(123)));
        tracks.add(new Track(6, 6, "TestTrack 6", new Time(123)));
    }

    private void createTrackInPlaylists() {
        tracksInPlaylist.add(new TrackInPlaylist(1, 1));
        tracksInPlaylist.add(new TrackInPlaylist(1, 2));
        tracksInPlaylist.add(new TrackInPlaylist(2, 3));
        tracksInPlaylist.add(new TrackInPlaylist(2, 4));
        tracksInPlaylist.add(new TrackInPlaylist(2, 5));
        tracksInPlaylist.add(new TrackInPlaylist(3, 6));
    }
}
