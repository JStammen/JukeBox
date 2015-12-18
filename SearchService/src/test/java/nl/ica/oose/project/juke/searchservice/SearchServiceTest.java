package nl.ica.oose.project.juke.searchservice;

import nl.ica.oose.project.juke.common.domain.Album;
import nl.ica.oose.project.juke.common.domain.Artist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.searchservice.persistence.SearchServiceDatabaseMock;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchServiceTest {
    private SearchService searchservice;

    @Before
    public void startup() {
        this.searchservice = new SearchService(new SearchServiceDatabaseMock());
    }

    @Test
    public void searchShouldReturnResultBasedOnTitle() throws NoResultFoundException, SQLException {
        List<Track> track = (List<Track>) searchservice.search("TestTrack 1").getEntity();
        assertEquals(track.get(0).getTitle(), "TestTrack 1");
    }

    @Test
    public void searchShouldReturnResultBasedOnArtist() throws NoResultFoundException, SQLException {
        List<Track> track = (List<Track>) searchservice.search("TestArtist 1").getEntity();
        assertEquals(track.get(0).getArtist().getArtistName(), "TestArtist 1");
    }

    @Test
    public void searchShouldReturnResultBasedOnAlbum() throws NoResultFoundException, SQLException {
        List<Track> track = (List<Track>) searchservice.search("TestAlbum 1").getEntity();
        assertEquals(track.get(0).getAlbum().getName(), "TestAlbum 1");
    }

    @Test
    public void searchShouldReturnMultipleResultsBasedOnTitle() throws NoResultFoundException, SQLException {
        List<Track> tracks = (List<Track>) searchservice.search("TestTrack").getEntity();
        List<Track> testtracks = getTestTrackList();

        for (int i = 0; i < tracks.size(); i++)
            assertEquals(tracks.get(i).getTitle(), testtracks.get(i).getTitle());
    }

    @Test
    public void searchShouldReturnMultipleResultsBasedOnArtist() throws NoResultFoundException, SQLException {
        List<Track> tracks = (List<Track>) searchservice.search("TestArtist").getEntity();
        List<Track> testtracks = getTestTrackList();

        for (int i = 0; i < tracks.size(); i++)
            assertEquals(tracks.get(i).getArtist().getArtistName(), testtracks.get(i).getArtist().getArtistName());
    }

    @Test
    public void searchShouldReturnMultipleResultsBasedOnAlbum() throws NoResultFoundException, SQLException {
        List<Track> tracks = (List<Track>) searchservice.search("TestAlbum").getEntity();
        List<Track> testtracks = getTestTrackList();

        for (int i = 0; i < tracks.size(); i++)
            assertEquals(tracks.get(i).getAlbum().getName(), testtracks.get(i).getAlbum().getName());
    }

    @Test(expected = NoResultFoundException.class)
    public void searchShouldNotFindAnythingBasedOnCriteria() throws NoResultFoundException, SQLException {
        Response response = searchservice.search("q");

        if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode())
            throw new NoResultFoundException();
    }

    @Test(expected = NoResultFoundException.class)
    public void searchShouldNotFindAnythingWhenWeirdCaractersAreUsed() throws NoResultFoundException, SQLException {
        Response response = searchservice.search("€");

        if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode())
            throw new NoResultFoundException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfCriteriaIsEmpty() {
        Response response = searchservice.search("");

        if (response.getStatus() == Response.Status.NOT_ACCEPTABLE.getStatusCode())
            throw new IllegalArgumentException();
    }

    @Test
    public void shouldThrowSQLException() {
        Response response = searchservice.search("IWANTTOTHROWASQLEXCEPTION");

        // TODO: FIX THIS. HACK TO UNIT TEST A SQL EXCEPTION.
        try {
            if (response.getStatus() == new SQLException().getErrorCode())
                throw new SQLException();
            else
                assertTrue(false);
        } catch (SQLException e) {
            assertTrue(true);
        }
    }

    private List<Track> getTestTrackList() {
        List<Track> testtracks = new ArrayList();
        testtracks.add(new Track(1, 1, "TestTrack 1", new Time(123)));
        testtracks.add(new Track(2, 2, "TestTrack 2", new Time(123)));
        testtracks.add(new Track(3, 3, "TestTrack 3", new Time(123)));
        testtracks.add(new Track(4, 4, "TestTrack 4", new Time(123)));
        testtracks.add(new Track(5, 5, "TestTrack 5", new Time(123)));
        testtracks.add(new Track(6, 6, "TestTrack 6", new Time(123)));

        testtracks.get(0).setAlbum(new Album(1, "TestAlbum 1"));
        testtracks.get(1).setAlbum(new Album(2, "TestAlbum 2"));
        testtracks.get(2).setAlbum(new Album(3, "TestAlbum 3"));
        testtracks.get(3).setAlbum(new Album(4, "TestAlbum 4"));
        testtracks.get(4).setAlbum(new Album(5, "TestAlbum 5"));
        testtracks.get(5).setAlbum(new Album(6, "TestAlbum 6"));

        testtracks.get(0).setArtist(new Artist(1, "TestArtist 1"));
        testtracks.get(1).setArtist(new Artist(2, "TestArtist 2"));
        testtracks.get(2).setArtist(new Artist(3, "TestArtist 3"));
        testtracks.get(3).setArtist(new Artist(4, "TestArtist 4"));
        testtracks.get(4).setArtist(new Artist(5, "TestArtist 5"));
        testtracks.get(5).setArtist(new Artist(6, "TestArtist 6"));
        return testtracks;
    }
}
