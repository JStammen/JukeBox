package nl.ica.oose.project.juke.common.persistence;

/**
 * This interface describes what a configuration class for the database should look like
 *
 * @author Kayan Meijer
 * @author Harm Tacoma
 */
public interface IDatabaseConfig {

    /**
     * basic getter for serverlocation
     *
     * @return the serverlocation of the database
     */
    public String getServerlocation();

    /**
     * basic setter for serverlocation
     *
     * @param serverlocation the location of the database server
     */
    public void setServerlocation(String serverlocation);

    /**
     * basic getter for username
     *
     * @return the username used for connecting with the database
     */
    public String getUsername();

    /**
     * basic setter for username
     *
     * @param username the username used for connecting with the database
     */
    public void setUsername(String username);

    /**
     * basic getter for password
     *
     * @return the password belonging to the user account on the database
     */
    public String getPassword();

    /**
     * basic setter for password
     *
     * @param password the password that belongs to the user account on the database
     */
    public void setPassword(String password);

    /**
     * basic getter for driver
     *
     * @return the driver of the database
     */
    public String getDriver();

    /**
     * basic setter for driver
     *
     * @param driver the driver of the database
     */
    public void setDriver(String driver);
}
