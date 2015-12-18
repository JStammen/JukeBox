package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrackDetailsTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private static final String GENRE = "Genre 1";
    private static final String MODIFIED_GENRE = "Genre 2";

    private static final int YEAR = 2014;
    private static final int MODIFIED_YEAR = 1999;

    private TrackDetail fullTrackDetail;
    private TrackDetail blankTrackDetail;

    @Before
    public void startup() {
        this.fullTrackDetail = new TrackDetail(ONE, GENRE, YEAR);
        this.blankTrackDetail = new TrackDetail();
    }

    @Test
    public void getTrackNumberShouldReturnOne() {
        assertEquals(fullTrackDetail.getTrackNumber(), ONE);
    }

    @Test
    public void setTrackNumberShouldNotFail() {
        fullTrackDetail.setTrackNumber(TWO);
        assertEquals(fullTrackDetail.getTrackNumber(), TWO);
    }

    @Test
    public void getTrackNumberShouldReturnZero() {
        assertEquals(blankTrackDetail.getTrackNumber(), ZERO);
    }

    @Test
    public void getGenreShouldReturnDefault() {
        assertEquals(fullTrackDetail.getGenre(), GENRE);
    }

    @Test
    public void setGenreShouldNotFail() {
        fullTrackDetail.setGenre(MODIFIED_GENRE);
        assertEquals(fullTrackDetail.getGenre(), MODIFIED_GENRE);
    }

    @Test
    public void getGenreShouldReturnNull() {
        assertNull(blankTrackDetail.getGenre());
    }

    @Test
    public void getYearShouldReturnDefault() {
        assertEquals(fullTrackDetail.getYear(), YEAR);
    }

    @Test
    public void setYearShouldNotFail() {
        fullTrackDetail.setYear(MODIFIED_YEAR);
        assertEquals(fullTrackDetail.getYear(), MODIFIED_YEAR);
    }

    @Test
    public void getYearShouldReturnZero() {
        assertEquals(blankTrackDetail.getYear(), ZERO);
    }
}
