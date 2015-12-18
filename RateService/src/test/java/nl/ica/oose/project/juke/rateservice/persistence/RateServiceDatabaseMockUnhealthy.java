package nl.ica.oose.project.juke.rateservice.persistence;

import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;

public class RateServiceDatabaseMockUnhealthy implements IRateServicePersistence {

    @Override
    public void rateTrack(int rating, String username, int trackID) throws SQLException, NoResultFoundException {
        throw new NotImplementedException();
    }

    @Override
    public int getAverage(int trackID) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public int getRating(int trackID, String username) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isValid() throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }
}
