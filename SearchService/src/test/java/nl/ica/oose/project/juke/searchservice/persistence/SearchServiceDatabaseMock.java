package nl.ica.oose.project.juke.searchservice.persistence;

import nl.ica.oose.project.juke.common.domain.Album;
import nl.ica.oose.project.juke.common.domain.Artist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceDatabaseMock implements ISearchServicePersistence {
    private List<Track> tracks = new ArrayList();
    private List<Artist> artists = new ArrayList();
    private List<Album> albums = new ArrayList();

    public SearchServiceDatabaseMock() {
        generateData();
    }

    private void generateData() {
        createArtists();
        createTracks();
        createAlbums();
        setAlbums();
        setArtists();
    }

    @Override
    public List<Track> search(String criteria) throws SQLException, NoResultFoundException {

        // TODO: HOW TO THROW A SQL EXCEPTION IN A MOCK?
        if ("IWANTTOTHROWASQLEXCEPTION".equals(criteria))
            throw new SQLException();


        if (criteria.isEmpty())
            throw new IllegalArgumentException();

        List<Track> retval = new ArrayList();

        for (Track track : tracks) {
            if (track.getTitle().contains(criteria) || track.getArtist().getArtistName().contains(criteria) || track.getAlbum().getName().contains(criteria)) {
                retval.add(track);
            }
        }

        if (retval == null || retval.size() == 0)
            throw new NoResultFoundException();

        return retval;
    }

    @Override
    public boolean isValid() throws SQLException {
        return !(tracks.isEmpty() || artists.isEmpty() || albums.isEmpty());
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }

    private void setArtists() {
        tracks.get(0).setArtist(artists.get(0));
        tracks.get(1).setArtist(artists.get(1));
        tracks.get(2).setArtist(artists.get(2));
        tracks.get(3).setArtist(artists.get(3));
        tracks.get(4).setArtist(artists.get(4));
        tracks.get(5).setArtist(artists.get(5));
    }

    private void setAlbums() {
        tracks.get(0).setAlbum(albums.get(0));
        tracks.get(1).setAlbum(albums.get(1));
        tracks.get(2).setAlbum(albums.get(2));
        tracks.get(3).setAlbum(albums.get(3));
        tracks.get(4).setAlbum(albums.get(4));
        tracks.get(5).setAlbum(albums.get(5));
    }

    private void createAlbums() {
        albums.add(new Album(1, "TestAlbum 1"));
        albums.add(new Album(2, "TestAlbum 2"));
        albums.add(new Album(3, "TestAlbum 3"));
        albums.add(new Album(4, "TestAlbum 4"));
        albums.add(new Album(5, "TestAlbum 5"));
        albums.add(new Album(6, "TestAlbum 6"));
    }

    private void createTracks() {
        tracks.add(new Track(1, 1, "TestTrack 1", new Time(123)));
        tracks.add(new Track(2, 2, "TestTrack 2", new Time(123)));
        tracks.add(new Track(3, 3, "TestTrack 3", new Time(123)));
        tracks.add(new Track(4, 4, "TestTrack 4", new Time(123)));
        tracks.add(new Track(5, 5, "TestTrack 5", new Time(123)));
        tracks.add(new Track(6, 6, "TestTrack 6", new Time(123)));
    }

    private void createArtists() {
        artists.add(new Artist(1, "TestArtist 1"));
        artists.add(new Artist(2, "TestArtist 2"));
        artists.add(new Artist(3, "TestArtist 3"));
        artists.add(new Artist(4, "TestArtist 4"));
        artists.add(new Artist(5, "TestArtist 5"));
        artists.add(new Artist(6, "TestArtist 6"));
    }
}
