package nl.ica.oose.project.juke.common.domain;

/**
 * This class represents the entity User
 *
 * @author Harm Tacoma
 */
public class User {

    private int userID;
    private String name;

    /**
     * Default constructor for User
     */
    public User() {

    }

    /**
     * The constructor for TrackInPlaylist
     *
     * @param userID the id of the user
     * @param name   the name of the user
     */
    public User(int userID, String name) {
        setName(name);
        setUserID(userID);
    }

    /**
     * Getter for userId
     *
     * @return the userId
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Setter for userId
     *
     * @param userID the userId
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Getter for name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

}
