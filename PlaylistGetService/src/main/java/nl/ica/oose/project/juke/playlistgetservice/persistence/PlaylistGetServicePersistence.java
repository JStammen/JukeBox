package nl.ica.oose.project.juke.playlistgetservice.persistence;

import nl.ica.oose.project.juke.common.domain.Album;
import nl.ica.oose.project.juke.common.domain.Artist;
import nl.ica.oose.project.juke.common.domain.Playlist;
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
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.Database
 * @see nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence
 */
public class PlaylistGetServicePersistence extends Database implements IPlaylistGetServicePersistence {

    /**
     * The constructor for PlaylistGetServicePersistence
     *
     * @param config a config class for database connection
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public PlaylistGetServicePersistence(IDatabaseConfig config) throws SQLException, ClassNotFoundException {
        super(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Track> getTracks(int playlistId) throws SQLException, NoResultFoundException {
        ResultSet result;
        result = statement.executeQuery(getGetTracksQuery(playlistId));

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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean verifyUser(int userId, int playlistId) throws SQLException {
        ResultSet result;
        result = statement.executeQuery(getVerifyQuery(userId, playlistId));
        return result.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Playlist> getPlaylists(int userId) throws SQLException, NoResultFoundException {
        ResultSet result;
        result = statement.executeQuery(getGetPlaylistsQuery(userId));
        ResultSetMapper<Playlist> resultSetMapper = new ResultSetMapper();
        List<Playlist> pl = resultSetMapper.mapResultSetToObject(result, Playlist.class);

        if (pl == null)
            throw new NoResultFoundException();
        return pl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getUserId(String username) throws SQLException, NoResultFoundException {
        ResultSet result;
        result = statement.executeQuery(getGetUserIdQuery(username));
        if (result.next()) {
            return result.getInt(1);
        }
        throw new NoResultFoundException();
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

    private String getVerifyQuery(int userId, int playlistId) {
        return "SELECT * FROM `playlist` WHERE `userID` = " + userId + " AND `playlistID` = " + playlistId;
    }

    private String getGetTracksQuery(int playlistId) {
        return "SELECT track.*,artist.*,album.albumname,album.albumID FROM `trackonplaylist` \n" +
                "INNER JOIN track on track.trackID = trackonplaylist.trackID \n" +
                "INNER JOIN trackonalbum ON track.trackID = trackonalbum.trackID \n" +
                "INNER JOIN artist ON artist.artistID = track.artistID \n" +
                "INNER JOIN album on album.albumID = trackonalbum.albumID \n" +
                "WHERE playlistID = " + playlistId;
    }

    private String getAlbumFromTrackId(int trackid) {
        return "SELECT * FROM album \n" +
                "INNER JOIN trackonalbum ON album.albumID = trackonalbum.albumID \n" +
                "WHERE trackID =" + trackid;
    }

    private String getArtistQuery(int artistid) {
        return "SELECT * FROM artist WHERE artistID =" + artistid;
    }

    private String getGetPlaylistsQuery(int userId) {
        return "SELECT * FROM `playlist` WHERE `userID` = " + userId;
    }

    private String getGetUserIdQuery(String username) {
        return "SELECT userID FROM user WHERE name LIKE '" + username + "'";
    }
}
