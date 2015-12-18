package nl.ica.oose.project.juke.common.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is responsible for connecting to the database and handling queries
 *
 * @author Kayan Meijer
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public class Database implements IDatabase {

    protected Connection connection;
    protected Statement statement;
    protected Logger logger;

    /**
     * The constructor to create a new instance of Database.
     *
     * @param config The used configuration for the Database.
     *
     */
    /**
     * The constructor to create a new instance of Database
     *
     * @param config The used configuration for the Database
     * @throws ClassNotFoundException can be thrown
     * @throws java.sql.SQLException  can be thrown
     */
    public Database(IDatabaseConfig config) throws ClassNotFoundException, SQLException {
        logger = LoggerFactory.getLogger(this.getClass());

        this.connection = DriverManager.getConnection(config.getServerlocation(), config.getUsername(), config.getPassword());
        this.statement = connection.createStatement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid() throws SQLException {
        return connection.isValid(1000);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
