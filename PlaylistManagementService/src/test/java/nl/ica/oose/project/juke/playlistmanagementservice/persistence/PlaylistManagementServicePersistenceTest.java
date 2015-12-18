package nl.ica.oose.project.juke.playlistmanagementservice.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class PlaylistManagementServicePersistenceTest {

    private static final String NEWPLAYLISTNAME = "THISISANEWNAME";
    private static final String USERNAME = "Admin";
    private static final int ONE = 1;
    public static final String INSERTFAILMESSAGE = "This insert should not fail";
    public static final String DELETEFAILMESSAGE = "This delete should not fail!";
    private PlaylistManagementServicePersistence playlistManagementServicePersistence;
    private H2Database database;

    @Before
    public void startUp() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.playlistManagementServicePersistence = new PlaylistManagementServicePersistence(new H2Config());
        this.database = new H2Database(playlistManagementServicePersistence.getConnection());

        database.create();
    }

    @Test
    public void createPlaylistShouldNotFail() {
        try {
            playlistManagementServicePersistence.createPlaylist(NEWPLAYLISTNAME, USERNAME);
        } catch (SQLException e) {
            fail(INSERTFAILMESSAGE);
        }
    }

    @Test
    public void deletePlaylistShouldNotFail() {
        try {
            playlistManagementServicePersistence.deletePlaylist(ONE);
        } catch (SQLException e) {
            fail(DELETEFAILMESSAGE);
        }
    }

    @After
    public void cleanUp() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
