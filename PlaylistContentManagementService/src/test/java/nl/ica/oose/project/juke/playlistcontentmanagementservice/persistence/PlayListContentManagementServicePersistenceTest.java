package nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class PlayListContentManagementServicePersistenceTest {

    private static final int playlistIDExisting = 1;
    private static final int trackIDNonExisting = 5;

    private static final int playlistIDNonExisting = 18;
    private static final int trackIDExisting = 1;

    public static final String INSERTFAILMESSAGE = "Adding the track failed";
    public static final String DELETEFAILMESSAGE = "Deleting track from playlist failed!";
    private PlayListContentManagementServicePersistence persistence;
    private H2Database database;

    @Before
    public void startUp() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.persistence = new PlayListContentManagementServicePersistence(new H2Config());
        this.database = new H2Database(persistence.getConnection());

        database.create();
    }

    @Test
    public void addTrackToPlaylistShouldNotFail() {
        try {
            persistence.addTrackOnPlaylist(playlistIDExisting, trackIDNonExisting);
        } catch (SQLException e) {
            fail(INSERTFAILMESSAGE);
        }
    }

    @Test(expected = SQLException.class)
    public void addTrackToPlaylistShouldFail() throws SQLException {
        persistence.addTrackOnPlaylist(playlistIDExisting, trackIDExisting);
    }

    @Test(expected = SQLException.class)
    public void addTrackToPlaylistShouldFailAlso() throws SQLException {
        persistence.addTrackOnPlaylist(playlistIDNonExisting, trackIDNonExisting);
    }

    @Test
    public void deleteTrackFromPlaylistShouldNotFail() {
        try {
            boolean result = persistence.deleteTrackOnPlaylist(playlistIDExisting, trackIDExisting);
            assertTrue(result);
        } catch (SQLException e) {
            fail(DELETEFAILMESSAGE);
        }
    }

    @Test
    public void deleteTrackShouldFailFakePlaylist() throws SQLException {
        boolean result = persistence.deleteTrackOnPlaylist(playlistIDNonExisting, trackIDExisting);
        assertFalse(result);
    }

    @Test
    public void deleteTrackShouldFailFakeTrack() throws SQLException {
        boolean result = persistence.deleteTrackOnPlaylist(playlistIDExisting, trackIDNonExisting);
        assertFalse(result);
    }

    @After
    public void cleanUp() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
