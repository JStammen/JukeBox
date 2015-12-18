package nl.ica.oose.project.juke.common.domain;

/**
 * This class is the representation of an rating
 *
 * @author Kayan Meijer
 */
public class Rating {

    private int rating;
    private int userID;
    private int trackID;

    /**
     * The empty constructor used for mapping ResultSet to a Rating.
     */
    public Rating() {

    }

    /**
     * The constructor used to create a new Rating
     *
     * @param rating  The value of the rating.
     * @param userID  The id of the user.
     * @param trackID The id of the track.
     */
    public Rating(int rating, int userID, int trackID) {
        this.rating = rating;
        this.userID = userID;
        this.trackID = trackID;
    }

    /**
     * Gets the Rating.
     *
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the Rating.
     *
     * @param rating rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the user id.
     *
     * @return userid.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Gets the track id.
     *
     * @return trackid.
     */
    public int getTrackID() {
        return trackID;
    }
}
