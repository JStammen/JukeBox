package nl.ica.oose.project.juke.searchservice.persistence;

import nl.ica.oose.project.juke.common.domain.Album;
import nl.ica.oose.project.juke.common.domain.Artist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.Database;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;
import nl.ica.oose.project.juke.common.persistence.ResultSetMapper;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The class that handles all the requests for the database
 *
 * @author Kayan Meijer
 * @author Jop Stammen
 * @see nl.ica.oose.project.juke.common.persistence.Database
 * @see nl.ica.oose.project.juke.searchservice.persistence.ISearchServicePersistence
 */
public class SearchServicePersistence extends Database implements ISearchServicePersistence {

    /**
     * A constructor to instantiate this class
     *
     * @param config a config class for database connection
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public SearchServicePersistence(IDatabaseConfig config) throws SQLException, ClassNotFoundException {
        super(config);
    }

    //todo search must accept songs without artist or album, not all nulls are problems
    //todo add tracklocation to searchresult

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Track> search(String criteria) throws SQLException, NoResultFoundException {
        if (criteria.isEmpty())
            throw new IllegalArgumentException("Criteria is empty.");

        ResultSet result;

        if ("%".equals(criteria))
            result = statement.executeQuery(getWildcardQuery());
        else
            result = statement.executeQuery(getSearchQuery(criteria));

        ResultSetMapper<Track> resultSetMapper = new ResultSetMapper();
        List<Track> tracks = resultSetMapper.mapResultSetToObject(result, Track.class);

        if (tracks == null)
            throw new NoResultFoundException();

        for (Track track : tracks) {
            Artist artist = getArtist(track.getArtistID());
            track.setArtist(artist);

            Album album = getAlbum(track.getTrackID());
            track.setAlbum(album);
        }

        return tracks;
    }

    private Artist getArtist(int artistid) throws SQLException, NoResultFoundException {
        ResultSet artistResult = statement.executeQuery(getArtistQuery(artistid));

        ResultSetMapper<Artist> artistResultMapper = new ResultSetMapper();
        List<Artist> artists = artistResultMapper.mapResultSetToObject(artistResult, Artist.class);

        if (artists == null)
            throw new NoResultFoundException();

        return artists.get(0);
    }

    private Album getAlbum(int trackid) throws SQLException, NoResultFoundException {
        ResultSet albumResult = statement.executeQuery(getAlbumFromTrackId(trackid));

        ResultSetMapper<Album> albumResultSetMapper = new ResultSetMapper();
        List<Album> albums = albumResultSetMapper.mapResultSetToObject(albumResult, Album.class);

        if (albums == null)
            throw new NoResultFoundException();

        return albums.get(0);
    }

    private String getSearchQuery(String criteria) {
        return "SELECT track.*,artist.*,album.albumname,album.albumID FROM `track` \n" +
                "INNER JOIN trackonalbum ON track.trackID = trackonalbum.trackID \n" +
                "INNER JOIN artist ON artist.artistID = track.artistID \n" +
                "INNER JOIN album on album.albumID = trackonalbum.albumID \n" +
                "WHERE track.title LIKE '%" + criteria + "%'\n" +
                "OR artist.artistName LIKE '%" + criteria + "%'\n" +
                "OR album.albumname LIKE '%" + criteria + "%'";
    }

    private String getWildcardQuery() {
        return "SELECT track.*,artist.*,album.albumname,album.albumID FROM `track` \n" +
                "INNER JOIN trackonalbum ON track.trackID = trackonalbum.trackID \n" +
                "INNER JOIN artist ON artist.artistID = track.artistID \n" +
                "INNER JOIN album on album.albumID = trackonalbum.albumID \n";
    }

    private String getAlbumFromTrackId(int trackid) {
        return "SELECT * FROM album \n" +
                "INNER JOIN trackonalbum ON album.albumID = trackonalbum.albumID \n" +
                "WHERE trackID =" + trackid;
    }

    private String getArtistQuery(int artistid) {
        return "SELECT * FROM artist WHERE artistID =" + artistid;
    }
}