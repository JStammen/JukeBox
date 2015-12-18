package nl.ica.oose.project.juke.playlistgetservice.Persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.playlistgetservice.persistence.PlaylistGetServicePersistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PlaylistGetServicePersistenceTest {
    private static final int USERID1 = 7;
    private static final int USERID2 = 8;
    private static final int PLAYLISTID1 = 1;
    private static final int PLAYLISTID2 = 16;
    private static final String GOODUSERNAME = "Harm";
    private static final String BADUSERNAME = "Obama";

    private PlaylistGetServicePersistence persistence;
    private H2Database database;

    @Before
    public void init() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.persistence = new PlaylistGetServicePersistence(new H2Config());
        this.database = new H2Database(persistence.getConnection());

        database.create();
    }

    @Test
    public void testVerifyUserNormal() throws SQLException {
        assertTrue(persistence.verifyUser(USERID1, PLAYLISTID1));
    }

    @Test
    public void testVerifyUserFalseUser() throws SQLException {
        assertFalse(persistence.verifyUser(USERID2, PLAYLISTID1));
    }

    @Test
    public void testVerifyUserFalsePlaylist() throws SQLException {
        assertFalse(persistence.verifyUser(USERID1, PLAYLISTID2));
    }

    @Test
    public void testGetPlaylistsNormal() throws NoResultFoundException, SQLException {
        List<Playlist> playlists = persistence.getPlaylists(USERID1);
        assertTrue(playlists.size() > 0);
    }

    @Test(expected = NoResultFoundException.class)
    public void testGetPlaylistsFail() throws SQLException, NoResultFoundException {
        persistence.getPlaylists(USERID2);
    }

    @Test
    public void testGetTracksNormal() throws NoResultFoundException, SQLException {
        List<Track> tracks = persistence.getTracks(PLAYLISTID1);
        assertTrue(tracks.size() > 0);
        assertTrue(tracks.size() == 4);
    }

    @Test(expected = NoResultFoundException.class)
    public void testGetTracksFail() throws NoResultFoundException, SQLException {
        persistence.getTracks(PLAYLISTID2);
    }

    @Test
    public void testGetUserIdNormal() throws NoResultFoundException, SQLException {
        int result = persistence.getUserId(GOODUSERNAME);
        assertEquals(result, 7);
    }

    @Test(expected = NoResultFoundException.class)
    public void testGetUserIdFail() throws NoResultFoundException, SQLException {
        persistence.getUserId(BADUSERNAME);
    }

    @After
    public void clean() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
