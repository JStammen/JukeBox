package nl.ica.oose.project.juke.importservice.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ImportServicePersistenceTest {

    private static final String UNKNOWNARTISTNAME = "VILLAGE PEOPLE";
    private static final String KNOWNARTISTNAME = "Slayer";
    private static final String TRACKTITLE = "YMCA";
    private static final String UNKNOWNALBUMTITLE = "BLA";
    private static final String KNOWNUNRELATEDALBUMTITLE = "Blurred Lines";
    private static final String KNOWNRELATEDALBUMTITLE = "Reign In Blood";
    private static final String TRACKLOCATION = "/this/is/a/fake/path/";

    private static final int TRACKID = 100;

    private ImportServicePersistence isp;
    private H2Database database;

    @Before
    public void startUp() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.isp = new ImportServicePersistence(new H2Config());
        this.database = new H2Database(isp.getConnection());

        database.create();
    }

    @Test
    public void insertTrackLocationShouldNotFail() throws SQLException {
        int[] result = isp.importTrack(KNOWNARTISTNAME, TRACKTITLE, UNKNOWNALBUMTITLE);
        isp.insertTrackLocation(result[0], TRACKLOCATION);
        ResultSet rs = database.getConnection().prepareStatement(getTrackLocationStatement(result[0])).executeQuery();
        String path = "";
        while (rs.next()) {
            path = rs.getString("PATH");
        }
        assertTrue(path.equals(TRACKLOCATION));
    }

    private String getTrackLocationStatement(int integer) {
        return "select path from tracklocation where trackid = " + integer;
    }

    @Test
    public void importTrackShouldSucceedArtistUnknown() throws SQLException {
        int[] result = isp.importTrack(UNKNOWNARTISTNAME, TRACKTITLE, UNKNOWNALBUMTITLE);
        assertTrue(result[0] == 20);
        assertTrue(result[1] == 9);
        assertTrue(result[2] == 55);
    }

    @Test
    public void importTrackShouldSucceedArtistKnown() throws SQLException {
        int[] result = isp.importTrack(KNOWNARTISTNAME, TRACKTITLE, UNKNOWNALBUMTITLE);
        assertTrue(result[0] == 20);
        assertTrue(result[1] == 1);
        assertTrue(result[2] == 55);
    }

    @Test
    public void importTrackShouldSucceedAlbumNameKnownUnrelated() throws SQLException {
        int[] result = isp.importTrack(KNOWNARTISTNAME, TRACKTITLE, KNOWNUNRELATEDALBUMTITLE);
        assertTrue(result[0] == 20);
        assertTrue(result[1] == 1);
        assertTrue(result[2] == 55);
    }

    @Test
    public void importTrackShouldSucceedAlbumNameKnownRelated() throws SQLException {
        int[] result = isp.importTrack(KNOWNARTISTNAME, TRACKTITLE, KNOWNRELATEDALBUMTITLE);
        assertTrue(result[0] == 20);
        assertTrue(result[1] == 1);
        assertTrue(result[2] == 2);
    }

    @After
    public void cleanUp() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
