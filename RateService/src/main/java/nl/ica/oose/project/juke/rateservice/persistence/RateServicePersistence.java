package nl.ica.oose.project.juke.rateservice.persistence;

import nl.ica.oose.project.juke.common.persistence.Database;
import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class responsible for the database request
 *
 * @author Kayan Meijer
 * @author Robbert de Wilde
 * @author Paul Kamps
 * @author Jop Stammen
 * @see nl.ica.oose.project.juke.common.persistence.Database
 * @see IRateServicePersistence
 */
public class RateServicePersistence extends Database implements IRateServicePersistence {

    private static final int ZERO = 0;

    /**
     * Constructor that initializes the class.
     *
     * @param config contains the configuration for the connection with the database
     * @throws java.sql.SQLException  if an query error occurred
     * @throws ClassNotFoundException if no result returns
     */
    public RateServicePersistence(IDatabaseConfig config) throws SQLException, ClassNotFoundException {
        super(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rateTrack(int rating, String username, int trackID) throws SQLException, NoResultFoundException {
        int userID = getuserID(username);
        insertOrReplaceRateTrack(rating, trackID, userID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAverage(int trackID) throws SQLException {
        ResultSet result = statement.executeQuery(getAverageQuery(trackID));

        int resultTotal = ZERO;
        int resultCount = ZERO;
        while (result.next()) {
            resultTotal += result.getInt("rating");
            resultCount++;
        }

        if (resultCount == ZERO)
            return ZERO;
        return resultTotal / resultCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRating(int trackID, String username) throws SQLException {
        int userID = getuserID(username);
        ResultSet result = getResultSetGetRating(trackID, userID);

        int rating = ZERO;
        while (result.next()) {
            rating = result.getInt("rating");
        }
        return rating;
    }

    private int getuserID(String username) throws SQLException {
        int userID = ZERO;
        ResultSet rs = getResultSetGetUserID(username);

        while (rs.next()) {
            userID = rs.getInt("userID");
        }
        return userID;
    }

    private ResultSet getResultSetGetUserID(String username) throws SQLException {
        return statement.executeQuery(getUserQuery(username));
    }

    private String getAverageQuery(int trackID) {
        return "SELECT * FROM rating WHERE trackID = " + trackID;
    }

    private void insertOrReplaceRateTrack(int intRating, int intTrackID, int userID) throws SQLException {
        statement.executeUpdate(getReplaceRateTrackQuery(intRating, userID, intTrackID));
    }

    private ResultSet getResultSetGetRating(int trackID, int userID) throws SQLException {
        return statement.executeQuery(getSelectRatingQuery(trackID, userID));
    }

    private String getReplaceRateTrackQuery(int rating, int userId, int trackId) {
        return "REPLACE INTO rating (rating, userID, trackID) VALUES (" + rating + "," + userId + "," + trackId + ")";
    }

    private String getSelectRatingQuery(int trackId, int userId) {
        return "SELECT * FROM rating WHERE trackID = " + trackId + " AND userID = " + userId;
    }

    private String getUserQuery(String username) {
        return "SELECT userID FROM user WHERE name = '" + username + "'";
    }
}