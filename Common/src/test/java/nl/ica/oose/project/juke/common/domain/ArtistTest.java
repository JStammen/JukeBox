package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistTest {
    private Artist artist;

    @Before
    public void startup() {
        this.artist = new Artist(1, "TestArtist 1");
    }

    @Test
    public void testGetArtistId() {
        assertEquals(1, artist.getArtistID());
    }

    @Test
    public void testGetArtistName() {
        assertTrue("TestArtist 1".equals(artist.getArtistName()));
    }

    @Test
    public void testDefaultConstructor() {
        Artist testartist = new Artist();
        assertNull(testartist.getArtistName());
        assertEquals(0, testartist.getArtistID());
    }

}
