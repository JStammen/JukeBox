package nl.ica.oose.project.juke.importservice.persistence;

import java.sql.SQLException;

public class ImportServiceDatabaseMockUnhealthy extends ImportServiceDatabaseMock {

    @Override
    public boolean isValid() throws SQLException {
        return false;
    }
}
