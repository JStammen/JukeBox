package nl.ica.oose.project.juke.rateservice;

import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.rateservice.persistence.RateServiceDatabaseMock;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RateServiceTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int ONEHUNDRED = 100;

    private static final String ONE_TEXT = "1";
    private static final String TWO_TEXT = "2";
    private static final String THREE_TEXT = "3";
    private static final String FOUR_TEXT = "4";

    private static final String ADMIN = "Admin";

    private RateService rateService;

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        this.rateService = new RateService(new RateServiceDatabaseMock());
    }

    @Test
    public void getRatingShouldNotFail() {
        int rating = (int) rateService.getRating(ONE, ADMIN).getEntity();
        assertEquals(ONE, rating);
    }

    @Test
    public void getRatingShouldReturnZeroIfNoRatingWasFound() {
        int rating = (int) rateService.getRating(THREE, ADMIN).getEntity();
        assertEquals(ZERO, rating);
    }

    @Test
    public void getRatingWithZeroAsParametersShouldThrowSQLException() throws NoResultFoundException, SQLException, IOException {
        Response response = rateService.getRating(ZERO, ADMIN);
        assertTrue(response.getStatus() == new SQLException().getErrorCode());
    }

    @Test
    public void rateNewTrackRatingShouldNotFail() throws NoResultFoundException, SQLException, IOException {
        rateService.rateTrack(TWO_TEXT, ONE_TEXT, THREE_TEXT);
        int addedRating = (int) rateService.getRating(THREE, ADMIN).getEntity();

        assertEquals(addedRating, TWO);
    }

    @Test
    public void rateExistingTrackRatingShouldAdjustRating() throws NoResultFoundException, SQLException, IOException {
        rateService.rateTrack(FOUR_TEXT, ONE_TEXT, TWO_TEXT);
        int addedRating = (int) rateService.getRating(TWO, ADMIN).getEntity();

        assertEquals(addedRating, FOUR);
    }

    @Test
    public void getAverageShouldReturnFour() {
        int average = (int) rateService.getAverage(FIVE).getEntity();
        assertEquals(average, FOUR);
    }

    @Test
    public void getAverageFromTrackWithNoRatingShouldReturnZero() {
        int average = (int) rateService.getAverage(ONEHUNDRED).getEntity();
        assertEquals(average, ZERO);
    }

    @Test
    public void getAverageWithZeroAsTrackIDShouldThrowSQLException() throws NoResultFoundException, SQLException, IOException {
        Response response = rateService.getAverage(ZERO);
        assertTrue(response.getStatus() == new SQLException().getErrorCode());
    }
}
