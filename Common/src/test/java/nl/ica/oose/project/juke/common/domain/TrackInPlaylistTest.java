package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrackInPlaylistTest {
    private static final int TRACKID1 = 1;
    private static final int TRACKID2 = 2;
    private static final int PLAYLISTID1 = 1;
    private static final int PLAYLISTID2 = 2;

    private TrackInPlaylist fulltip;
    private TrackInPlaylist blanktip;

    @Before
    public void init() {
        fulltip = new TrackInPlaylist(PLAYLISTID1, TRACKID1);
        blanktip = new TrackInPlaylist();
    }

    @Test
    public void trackIdGetterNormal() {
        assertEquals(fulltip.getTrackId(), TRACKID1);
    }

    @Test
    public void trackIdGetterZero() {
        assertEquals(blanktip.getTrackId(), 0);
    }

    @Test
    public void trackIdSetter() {
        fulltip.setTrackId(TRACKID2);
        assertEquals(fulltip.getTrackId(), TRACKID2);
    }

    @Test
    public void playlistIdGetterNormal() {
        assertEquals(fulltip.getPlaylistId(), PLAYLISTID1);
    }

    @Test
    public void playlistIdGetterZero() {
        assertEquals(blanktip.getPlaylistId(), 0);
    }

    @Test
    public void playlistIdSetter() {
        fulltip.setPlaylistId(PLAYLISTID2);
        assertEquals(fulltip.getPlaylistId(), PLAYLISTID2);
    }
}
