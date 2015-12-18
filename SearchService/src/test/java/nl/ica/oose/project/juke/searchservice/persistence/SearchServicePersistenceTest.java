package nl.ica.oose.project.juke.searchservice.persistence;

import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchServicePersistenceTest {

    private static final int ONE = 1;
    private static final int DEMODATACOUNT = 19;

    private static final String BLANK = "";

    private static final String ONERESULTTRACKTITLECRITERIA = "War Ensemble";
    private static final String NORESULTCRITERIA = "This Should Not Give Any Results";
    private static final String WILDCARDCRITERIA = "%";

    private SearchServicePersistence searchServicePersistence;
    private H2Database database;

    @Before
    public void startUp() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.searchServicePersistence = new SearchServicePersistence(new H2Config());
        this.database = new H2Database(searchServicePersistence.getConnection());

        database.create();
    }

    @Test
    public void searchShouldReturnOneTrack() throws NoResultFoundException, SQLException {
        List<Track> response = searchServicePersistence.search(ONERESULTTRACKTITLECRITERIA);
        assertTrue(response.size() == ONE);
    }

    @Test(expected = NoResultFoundException.class)
    public void searchShouldThrowNoResultFoundException() throws SQLException, NoResultFoundException {
        List<Track> response = searchServicePersistence.search(NORESULTCRITERIA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchShouldThrowIlegalArgumentException() throws SQLException, NoResultFoundException {
        List<Track> response = searchServicePersistence.search(BLANK);
    }

    @Test
    public void searchShouldReturnAllRecordsWhenCriteriaIsWildcard() throws SQLException, NoResultFoundException {
        List<Track> response = searchServicePersistence.search(WILDCARDCRITERIA);
        assertEquals(response.size(), DEMODATACOUNT);
    }

    @After
    public void cleanUp() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
