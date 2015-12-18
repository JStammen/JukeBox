package nl.ica.oose.project.juke.rateservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabase;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;

import java.sql.SQLException;

/**
 * This interface defines what the database class for RateTrackService should be able to do
 *
 * @author Jop Stammen
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface IRateServicePersistence extends IDatabase {

    /**
     * Method that rates a track with a rating that is given by a user for a track
     *
     * @param rating   the given rating
     * @param username the user who gives the rating
     * @param trackID  the track that is being rated
     * @throws java.sql.SQLException                                                         if an query error occurred
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException if no result returns
     */
    public void rateTrack(int rating, String username, int trackID) throws SQLException, NoResultFoundException;

    /**
     * Method that calculates the average rating of a track
     *
     * @param trackID the selected track
     * @return the average rating of a track
     * @throws java.sql.SQLException if an query error occurred
     */
    public int getAverage(int trackID) throws SQLException;

    /**
     * Method returns a rating for specific user and track
     *
     * @param trackID  is the selected track
     * @param username is the logged in user.
     * @return the rating that a user has given on the trackID
     * @throws java.sql.SQLException if an query error occurred
     */
    public int getRating(int trackID, String username) throws SQLException;
}
