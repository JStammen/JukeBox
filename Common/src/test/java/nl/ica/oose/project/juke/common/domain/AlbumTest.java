package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AlbumTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private static final String ALBUMNAME = "TestAlbum 1";
    private static final String MODIFIED_ALBUMNAME = "THISISMODIFIED";

    private Album fullAlbum;
    private Album blankAlbum;

    @Before
    public void startup() {
        this.fullAlbum = new Album(ONE, ALBUMNAME);
        this.blankAlbum = new Album();
    }

    @Test
    public void getAlbumIDShouldReturnOne() {
        assertEquals(fullAlbum.getAlbumID(), ONE);
    }

    @Test
    public void getAndGetAlbumIDShouldReturnTwo() {
        fullAlbum.setAlbumID(TWO);
        assertEquals(fullAlbum.getAlbumID(), TWO);
    }

    @Test
    public void shouldReturnZeroIfAlbumIDIsEmpty() {
        assertEquals(blankAlbum.getAlbumID(), ZERO);
    }

    @Test
    public void getNameShouldReturnDefaultName() {
        assertEquals(fullAlbum.getName(), ALBUMNAME);
    }

    @Test
    public void getNameShouldReturnModifiedName() {
        fullAlbum.setName(MODIFIED_ALBUMNAME);
        assertEquals(fullAlbum.getName(), MODIFIED_ALBUMNAME);
    }

    @Test
    public void shouldReturnNullIfNameIsEmpty() {
        assertNull(blankAlbum.getName());
    }
}
