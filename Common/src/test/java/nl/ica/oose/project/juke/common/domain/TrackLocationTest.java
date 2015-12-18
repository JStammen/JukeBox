package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class TrackLocationTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final String PATH = "this/is/a/test/path/";

    private TrackLocation fullTrackLocation;
    private TrackLocation blankTrackLocation;

    @Before
    public void startUp() {
        this.fullTrackLocation = new TrackLocation(ONE, PATH);
        this.blankTrackLocation = new TrackLocation();
    }

    @Test
    public void getTrackIDShouldReturnOne() {
        assertEquals(fullTrackLocation.getTrackID(), ONE);
    }

    @Test
    public void getTrackIDShouldReturnZero() {
        assertEquals(blankTrackLocation.getTrackID(), ZERO);
    }

    @Test
    public void getPathShouldReturnDefault() {
        assertEquals(fullTrackLocation.getPath(), PATH);
    }

    @Test
    public void getPathShouldReturnNull() {
        assertNull(blankTrackLocation.getPath());
    }

}
