package nl.ica.oose.project.juke.rateservice.persistence;

import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

public class RateServicePeristenceTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int ONEHUNDRED = 100;

    private static final String ADMIN = "Admin";

    private RateServicePersistence rateTrackServicePersistence;
    private H2Database database;

    @Before
    public void startUp() throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        this.rateTrackServicePersistence = new RateServicePersistence(new H2Config());
        this.database = new H2Database(rateTrackServicePersistence.getConnection());

        database.create();
    }

    @Test
    public void rateTrackShouldNotFail() throws NoResultFoundException, SQLException {
        rateTrackServicePersistence.rateTrack(FIVE, ADMIN, FIVE);
        assertEquals(rateTrackServicePersistence.getRating(FIVE, ADMIN), FIVE);
    }

    @Test
    public void getAverageShouldReturnTwoIfMultiplePeopleHaveRated() throws SQLException {
        int average = rateTrackServicePersistence.getAverage(ONE);
        assertEquals(average, TWO);
    }

    @Test
    public void getAverageShouldReturnZeroIfNoOneHasRated() throws SQLException {
        int average = rateTrackServicePersistence.getAverage(THREE);
        assertEquals(average, ZERO);
    }

    @Test
    public void getAverageShouldReturnZeroIfNoTrackWasFoundWithTheTrackID() throws SQLException {
        int average = rateTrackServicePersistence.getAverage(ONEHUNDRED);
        assertEquals(average, ZERO);
    }

    @Test
    public void getRatingShouldReturnThree() throws SQLException {
        int rating = rateTrackServicePersistence.getRating(ONE, ADMIN);
        assertEquals(rating, THREE);
    }

    @Test
    public void getRatingShouldReturnZeroIfNotRated() throws SQLException {
        int rating = rateTrackServicePersistence.getRating(THREE, ADMIN);
        assertEquals(rating, ZERO);
    }

    @Test
    public void getRatingShouldReturnZeroIfTrackDoesNotExist() throws SQLException {
        int rating = rateTrackServicePersistence.getRating(ONEHUNDRED, ADMIN);
        assertEquals(rating, ZERO);
    }

    @After
    public void cleanUp() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        database.drop();
    }
}
