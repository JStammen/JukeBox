package nl.ica.oose.project.juke.importservice;


import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.importservice.persistence.IImportServicePersistence;
import nl.ica.oose.project.juke.importservice.persistence.IImportServiceSftp;

import java.sql.SQLException;

/**
 * Healthcheck for ImportService to be able to test if ImportService is still healthy in runtime
 *
 * @author Harm Tacoma
 * @see com.codahale.metrics.health.HealthCheck
 */
public class ImportServiceHealthCheck extends HealthCheck {

    private static final String BOTHARGUMENTSNULLMESSAGE = "Both database and sftp are null.";
    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";
    private static final String SFTPARGUMENTNULLMESSAGE = "Sftp argument was null.";

    private static final String DATABASE_AND_SFTP_ARE_NOT_VALID = "Both the FTP and Database connection timed out.";
    private static final String DATABASE_CONNECTION_TIMED_OUT = "Database connection timed out.";
    private static final String FTP_CONNECTION_TIMED_OUT = "FTP connection timed out.";
    private static final String UNKNOWN_FAIL = "Unknown healthcheck fail.";

    private IImportServicePersistence database;
    private IImportServiceSftp sftp;
    private String message;

    /**
     * Constructor for the healthcheck
     *
     * @param database configuration and information of the database
     * @param sftp     the information needed for the sftp connection
     */
    public ImportServiceHealthCheck(IImportServicePersistence database, IImportServiceSftp sftp) {
        validateParameters(database, sftp);

        this.database = database;
        this.sftp = sftp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Result check() throws Exception {
        return doHealthCheck();
    }

    private Result doHealthCheck() throws SQLException {
        if (bothDatabaseAndSftpAreValid())
            return Result.healthy();
        else if (bothDatabaseAndSftpAreNotValid())
            return Result.unhealthy(DATABASE_AND_SFTP_ARE_NOT_VALID);
        else if (databaseIsNotValid())
            return Result.unhealthy(DATABASE_CONNECTION_TIMED_OUT);
        else if (sftpIsNotValid())
            return Result.unhealthy(FTP_CONNECTION_TIMED_OUT);
        return Result.unhealthy(UNKNOWN_FAIL);
    }

    private boolean sftpIsNotValid() {
        return !sftp.isValid();
    }

    private boolean databaseIsNotValid() throws SQLException {
        return !database.isValid();
    }

    private boolean bothDatabaseAndSftpAreNotValid() throws SQLException {
        return (databaseIsNotValid()) && (sftpIsNotValid());
    }

    private boolean bothDatabaseAndSftpAreValid() throws SQLException {
        return database.isValid() && sftp.isValid();
    }

    private void validateParameters(IImportServicePersistence database, IImportServiceSftp sftp) {
        this.database = database;
        this.sftp = sftp;
        if (database == null && sftp == null)
            throwNullpointerException(BOTHARGUMENTSNULLMESSAGE);
        else if (database == null)
            throw new NullPointerException(DATABASEARGUMENTNULLMESSAGE);
        else if (sftp == null)
            throwNullpointerException(SFTPARGUMENTNULLMESSAGE);
    }

    private void throwNullpointerException(String message) {
        this.message = message;
        throw new NullPointerException(message);
    }
}
