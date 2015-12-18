package nl.ica.oose.project.juke.searchservice.persistence;

import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.IDatabase;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * This interface describes what the Database class for SearchService should be able to do
 *
 * @author Kayan Meijer
 * @see nl.ica.oose.project.juke.common.persistence.IDatabase
 */
public interface ISearchServicePersistence extends IDatabase {

    /**
     * A method to search tracks based on the variable criteria
     *
     * @param criteria the value to search on
     * @return a list of found tracks
     * @throws java.sql.SQLException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     */
    public List<Track> search(String criteria) throws SQLException, NoResultFoundException;
}
