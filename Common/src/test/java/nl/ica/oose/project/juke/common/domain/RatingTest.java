package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RatingTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    private Rating fullRating;
    private Rating blankRating;

    @Before
    public void startUp() {
        this.fullRating = new Rating(FIVE, ONE, TWO);
        this.blankRating = new Rating();
    }

    @Test
    public void getRatingShouldReturnFive() {
        assertEquals(fullRating.getRating(), FIVE);
    }

    @Test
    public void getRatingShouldReturnZero() {
        assertEquals(blankRating.getRating(), ZERO);
    }

    @Test
    public void setRatingShouldReturnThreeWhenModified() {
        fullRating.setRating(THREE);
        assertEquals(fullRating.getRating(), THREE);
    }

    @Test
    public void getTrackIDShouldReturnOne() {
        assertEquals(fullRating.getTrackID(), TWO);
    }

    @Test
    public void getTrackIDShouldReturnZero() {
        assertEquals(blankRating.getTrackID(), ZERO);
    }

    @Test
    public void getUserIDShouldReturnOne() {
        assertEquals(fullRating.getUserID(), ONE);
    }

    @Test
    public void getUserIDShouldReturnZero() {
        assertEquals(blankRating.getUserID(), ZERO);
    }
}
