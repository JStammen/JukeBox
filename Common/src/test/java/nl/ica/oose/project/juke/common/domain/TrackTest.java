package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrackTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private static final String TRACKNAME = "TestTrack 1";
    private static final String ARTISTNAME = "TestArtist 1";
    private static final String ALBUMNAME = "TestAlbum 1";

    private static final Time TRACKDURATION = new Time(123);

    private static final String MODIFIED_TRACKNAME = "Modified Track Name";
    private static final String MODIFIED_ARTISTNAME = "TestArtist 2";
    private static final Time MODIFIED_TRACKDURATION = new Time(456);
    private static final String MODIFIED_ALBUMNAME = "TestAlbum 2";

    private Track fullTrack;
    private Track semiFilledTrack;
    private Track blankTrack;

    private Artist artist;
    private Album album;

    private Artist modifiedArtist;
    private Album modifiedAlbum;

    @Before
    public void startup() {

        artist = new Artist(ONE, ARTISTNAME);
        album = new Album(ONE, ALBUMNAME);

        modifiedArtist = new Artist(TWO, MODIFIED_ARTISTNAME);
        modifiedAlbum = new Album(TWO, MODIFIED_ALBUMNAME);

        this.fullTrack = new Track(ONE, ONE, TRACKNAME, TRACKDURATION, artist, album);
        this.semiFilledTrack = new Track(ONE, ONE, TRACKNAME, TRACKDURATION);
        this.blankTrack = new Track();
    }

    @Test
    public void getTrackIDShouldReturnOne() {
        assertEquals(fullTrack.getTrackID(), ONE);
    }

    @Test
    public void getTrackIDShouldReturnTwo() {
        fullTrack.setTrackID(TWO);
        assertEquals(fullTrack.getTrackID(), TWO);
    }

    @Test
    public void shouldReturnNullIfTrackIDIsEmpty() {
        assertEquals(blankTrack.getTrackID(), ZERO);
    }

    @Test
    public void getArtistIDShouldReturnOne() {
        assertEquals(fullTrack.getArtistID(), ONE);
    }

    @Test
    public void getArtistIDShouldReturnTwo() {
        fullTrack.setArtistID(TWO);
        assertEquals(fullTrack.getArtistID(), TWO);
    }

    @Test
    public void shouldReturnNullIfArtistIDIsEmpty() {
        assertEquals(blankTrack.getArtistID(), ZERO);
    }

    @Test
    public void getTitleShouldReturnOne() {
        assertEquals(fullTrack.getTitle(), TRACKNAME);
    }

    @Test
    public void getTitleShouldReturnModifiedTitle() {
        fullTrack.setTitle(MODIFIED_TRACKNAME);
        assertEquals(fullTrack.getTitle(), MODIFIED_TRACKNAME);
    }

    @Test
    public void shouldReturnNullIfTitleIsEmpty() {
        assertNull(blankTrack.getTitle());
    }

    @Test
    public void getDurationShouldReturnOne() {
        assertEquals(fullTrack.getDuration(), TRACKDURATION);
    }

    @Test
    public void getDurationShouldReturnModifiedDuration() {
        fullTrack.setDuration(MODIFIED_TRACKDURATION);
        assertEquals(fullTrack.getDuration(), MODIFIED_TRACKDURATION);
    }

    @Test
    public void shouldReturnNullIfDurationIsEmpty() {
        assertNull(blankTrack.getDuration());
    }

    @Test
    public void getArtistShouldBeEqual() {
        assertEquals(fullTrack.getArtist(), artist);
    }

    @Test
    public void semiFilledTrackGetArtistShouldReturnNull() {
        assertNull(semiFilledTrack.getArtist());
    }

    @Test
    public void blankTrackGetArtistShouldReturnNull() {
        assertNull(blankTrack.getArtist());
    }

    @Test
    public void setArtistShouldNotFail() {
        fullTrack.setArtist(modifiedArtist);
        assertEquals(fullTrack.getArtist(), modifiedArtist);
    }

    @Test
    public void getAlbumShouldBeEqual() {
        assertEquals(fullTrack.getAlbum(), album);
    }

    @Test
    public void setSemiFilledTrackGetAlbumShouldReturnNull() {
        assertNull(semiFilledTrack.getAlbum());
    }

    @Test
    public void blankTrackGetAlbumShouldReturnNull() {
        assertNull(blankTrack.getAlbum());
    }

    @Test
    public void setAlbumShouldNotFail() {
        fullTrack.setAlbum(modifiedAlbum);
        assertEquals(fullTrack.getAlbum(), modifiedAlbum);
    }
}
