package nl.ica.oose.project.juke.importservice.persistence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;

public class ImportServiceDatabaseMock implements IImportServicePersistence {

    public int[] importTrack(String artist, String title, String albumtitle) throws SQLException {
        int[] result = new int[3];
        result[0] = 25;
        result[1] = 1;
        result[2] = 1;
        return result;
    }

    public void insertTrackLocation(int trackid, String tracklocation) throws SQLException {

    }

    @Override
    public boolean isValid() throws SQLException {
        return true;
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }
}
