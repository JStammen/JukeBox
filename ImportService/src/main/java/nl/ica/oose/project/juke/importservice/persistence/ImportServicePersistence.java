package nl.ica.oose.project.juke.importservice.persistence;

import nl.ica.oose.project.juke.common.persistence.Database;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The database class for ImportService. Handles all things related to the database
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.importservice.persistence.IImportServicePersistence
 * @see nl.ica.oose.project.juke.common.persistence.Database
 */
public class ImportServicePersistence extends Database implements IImportServicePersistence {

    private static String durationPlaceHolder = "'00:03:23'";

    /**
     * Constructor of the ImportServicePersistence
     *
     * @param config config file of the database
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public ImportServicePersistence(IDatabaseConfig config) throws SQLException, ClassNotFoundException {
        super(config);
    }

    //todo import must import all data or insert nulls, not false data
    //todo make import first place file in temp -> then analyze id3tags -> return those to website -> let user fill in own info -> send info to database AND id3tags -> get trackid -> send file to ftp location -> save location to database
    //todo extract methods

    /**
     * {@inheritDoc}
     */
    public int[] importTrack(String artist, String title, String albumtitle) throws SQLException {
        int[] results = new int[3];
        results[0] = 0;//trackid
        results[1] = 0;//artistid
        results[2] = 0;//albumid
        results[1] = getArtistId(artist);
        results[0] = insertTrack(title, results[1]);
        results[2] = getAlbumId(albumtitle, results[1]);
        insertTrackOnAlbum(results[0], results[2]);
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public void insertTrackLocation(int trackid, String tracklocation) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(getInsertTracklocationQuery());
        pstm.setInt(1, trackid);
        pstm.setString(2, tracklocation);
        pstm.executeUpdate();
    }

    private int insertTrack(String title, int artistId) throws SQLException {
        int result = 0;
        statement.executeUpdate(getInsertTrackQuery(artistId, title), statement.RETURN_GENERATED_KEYS);
        ResultSet keys = statement.getGeneratedKeys();
        if (keys.next()) {
            result = keys.getInt(1);
        }
        return result;
    }

    private int getArtistId(String artist) throws SQLException {
        ResultSet rs1 = statement.executeQuery(getSelectArtistQuery(artist));
        if (rs1.next()) {
            return rs1.getInt("ArtistID");
        } else return insertArtist(artist);
    }

    private int getAlbumId(String albumtitle, int artistId) throws SQLException {
        ResultSet rs2 = statement.executeQuery(getSelectAlbumQuery(albumtitle, artistId));
        if (rs2.next()) {
            return rs2.getInt("albumID");
        } else return insertAlbum(artistId, albumtitle);
    }

    private int insertArtist(String artist) throws SQLException {
        statement.executeUpdate(getInsertArtistQuery(artist), statement.RETURN_GENERATED_KEYS);
        ResultSet keys = statement.getGeneratedKeys();
        int result = 0;
        if (keys.next()) {
            result = keys.getInt(1);
        }
        return result;
    }

    private int insertAlbum(int artistID, String albumtitle) throws SQLException {
        statement.executeUpdate(getInsertAlbumQuery(artistID, albumtitle), statement.RETURN_GENERATED_KEYS);
        ResultSet keys = statement.getGeneratedKeys();
        int result = 0;
        if (keys.next()) {
            result = keys.getInt(1);
        }
        return result;
    }

    private void insertTrackOnAlbum(int trackid, int albumid) throws SQLException {
        statement.executeUpdate(getInsertTrackOnAlbumQuery(trackid, albumid));
    }

    private String getInsertAlbumQuery(int artistID, String albumtitle) {
        return "INSERT INTO album(artistID,albumname)VALUES (" + artistID + ",'" + albumtitle + "')";
    }

    private String getInsertArtistQuery(String artist) {
        return "INSERT INTO artist(artistName)VALUES('" + artist + "')";
    }

    private String getInsertTrackOnAlbumQuery(int trackid, int albumid) {
        return "INSERT INTO trackonalbum(trackID, albumID)VALUES(" + trackid + "," + albumid + ")";
    }

    private String getInsertTracklocationQuery() {
        return "INSERT INTO tracklocation (trackid, path) VALUES (?,?)";
    }

    private String getSelectAlbumQuery(String title, int artistId) {
        return "Select albumID from album where albumname LIKE " + "'" + title + "' AND artistID =" + artistId;
    }

    private String getInsertTrackQuery(int artistId, String title) {
        return "INSERT INTO track(artistID, title, duration)VALUES(" + artistId + ",'" + title + "'," + durationPlaceHolder + ")";
    }

    private String getSelectArtistQuery(String artist) {
        return "Select artistID from artist where artistname LIKE " + "'" + artist + "'";
    }
}
