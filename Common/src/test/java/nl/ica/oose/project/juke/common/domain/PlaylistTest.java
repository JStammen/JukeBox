package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlaylistTest {

    private static final int PLAYLISTID1 = 1;
    private static final int PLAYLISTID2 = 2;

    private static final String NAME1 = "Ja";
    private static final String NAME2 = "Nee";

    private static final int USERID1 = 3;
    private static final int USERID2 = 4;

    private Playlist blankPlaylist;
    private Playlist fullPlaylist;

    @Before
    public void startUp() {
        this.blankPlaylist = new Playlist();
        this.fullPlaylist = new Playlist(PLAYLISTID1, NAME1, USERID1);
    }

    @Test
    public void testPlaylistIdGetterNormal() {
        assertEquals(fullPlaylist.getPlaylistID(), PLAYLISTID1);
    }

    @Test
    public void testPlaylistIdGetterZero() {
        assertEquals(blankPlaylist.getPlaylistID(), 0);
    }

    @Test
    public void testNameGetterNormal() {
        assertEquals(fullPlaylist.getName(), NAME1);
    }

    @Test
    public void testNameGetterNull() {
        assertNull(blankPlaylist.getName());
    }

    @Test
    public void testUserIdGetterNormal() {
        assertEquals(fullPlaylist.getUserID(), USERID1);
    }

    @Test
    public void testUserIdGetterZero() {
        assertEquals(blankPlaylist.getUserID(), 0);
    }

    @Test
    public void testModifiedPlaylistId() {
        fullPlaylist.setPlaylistID(PLAYLISTID2);
        assertEquals(fullPlaylist.getPlaylistID(), PLAYLISTID2);
    }

    @Test
    public void testModifiedName() {
        fullPlaylist.setName(NAME2);
        assertEquals(fullPlaylist.getName(), NAME2);
    }

    @Test
    public void testModifiedUserId() {
        fullPlaylist.setUserID(USERID2);
        assertEquals(fullPlaylist.getUserID(), USERID2);
    }
}
