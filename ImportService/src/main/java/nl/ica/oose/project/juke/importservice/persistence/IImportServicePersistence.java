package nl.ica.oose.project.juke.importservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabase;

import java.sql.SQLException;

/**
 * This interface describes the database class for ImportService
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface IImportServicePersistence extends IDatabase {

    /**
     * Method to import tracks
     *
     * @param artist     artist of the track
     * @param title      title of the track
     * @param albumtitle title of the album
     * @return an array of 3 integers, first being trackid, second artistid and third albumid
     * @throws java.sql.SQLException
     */
    public int[] importTrack(String artist, String title, String albumtitle) throws SQLException;

    /**
     * Method to insert TrackLocation into database
     *
     * @param trackid       the trackID of the inserted track
     * @param tracklocation the location of the inserted track
     * @throws java.sql.SQLException
     */
    public void insertTrackLocation(int trackid, String tracklocation) throws SQLException;
}
