package nl.ica.oose.project.juke.common.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This interface defines a class that is responsible for connecting to the database and handling queries
 *
 * @author Harm Tacoma
 * @author Kayan Meijer
 */
public interface IDatabase {

    /**
     * Gets if the connection with the database was valid.
     *
     * @return isvalid.
     * @throws java.sql.SQLException Throws SQLException.
     */
    public boolean isValid() throws SQLException;

    /**
     * Gets the connection used for the database.
     *
     * @return connection.
     */
    public Connection getConnection();
}
