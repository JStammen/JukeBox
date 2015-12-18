package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistManagementServicePersistenceMock implements IPlaylistManagementServicePersistence {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;

    private List<Playlist> playlists = new ArrayList();
    private List<User> users = new ArrayList();

    public PlaylistManagementServicePersistenceMock() {
        generateData();
    }

    @Override
    public void createPlaylist(String playlistName, String userName) throws SQLException {

        int userID = getUserIDFromUserName(userName);
        int highestID = -1;

        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistID() > highestID)
                highestID = playlist.getPlaylistID();
        }

        playlists.add(new Playlist(highestID + 1, playlistName, userID));
    }

    @Override
    public void deletePlaylist(int playlistID) throws SQLException {

        Playlist toDelete = null;

        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistID() == playlistID)
                toDelete = playlist;
        }

        playlists.remove(toDelete);
    }

    @Override
    public boolean isValid() throws SQLException {
        return !playlists.isEmpty();
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }

    private int getUserIDFromUserName(String userName) {

        int userID = -1;

        for (User user : users) {
            if (user.getName().equals(userName))
                userID = user.getUserID();
        }

        return userID;
    }

    private void generateData() {

        users.add(new User(ONE, "Admin"));
        users.add(new User(TWO, "Harm"));
        users.add(new User(THREE, "Robbert"));
        users.add(new User(FOUR, "Paul"));
        users.add(new User(FIVE, "Jop"));
        users.add(new User(SIX, "Albert"));
        users.add(new User(EIGHT, "Bert"));
        users.add(new User(SEVEN, "Piet"));
        users.add(new User(NINE, "Hein"));
        users.add(new User(TEN, "Jan"));

        playlists.add(new Playlist(ONE, "NAAM PLAYLIST 1", ONE));
        playlists.add(new Playlist(TWO, "NAAM PLAYLIST 1", TWO));
        playlists.add(new Playlist(THREE, "NAAM PLAYLIST 1", THREE));
        playlists.add(new Playlist(FOUR, "NAAM PLAYLIST 1", FOUR));
        playlists.add(new Playlist(FIVE, "NAAM PLAYLIST 1", FIVE));
        playlists.add(new Playlist(SIX, "NAAM PLAYLIST 1", SIX));
        playlists.add(new Playlist(SEVEN, "NAAM PLAYLIST 1", SEVEN));
        playlists.add(new Playlist(EIGHT, "NAAM PLAYLIST 1", EIGHT));
        playlists.add(new Playlist(NINE, "NAAM PLAYLIST 1", NINE));
        playlists.add(new Playlist(TEN, "NAAM PLAYLIST 1", TEN));
    }
}
