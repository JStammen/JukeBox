package nl.ica.oose.project.juke.searchservice.persistence;

import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SearchServiceDatabaseMockUnhealthy implements ISearchServicePersistence {

    @Override
    public List<Track> search(String criteria) throws SQLException, NoResultFoundException {
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
