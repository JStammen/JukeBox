package nl.ica.oose.project.juke.importservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabase;
import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

public class H2Database implements IDatabase {

    private static final String REPLACEFILEFROMSTRING = "file:";
    private static final String BLANK = "";
    private static final String ENCODINGTYPE = "UTF-8";
    private static final String CREATESCRIPTNAME = "createH2Database.sql";
    private static final String IMPORTDATASCRIPTNAME = "InsertDataH2Database.sql";
    private static final String DROPSCRIPTNAME = "dropH2Database.sql";
    private Connection connection;

    public H2Database(Connection connection) {
        this.connection = connection;
    }

    public void create() throws UnsupportedEncodingException, FileNotFoundException, SQLException {
        String fileLoc = getCreateScriptLocation();
        RunScript.execute(connection, new FileReader(fileLoc));

        createData();
    }

    public void drop() throws UnsupportedEncodingException, FileNotFoundException, SQLException {
        String fileLoc = getDropDatabaseScriptLocation();
        RunScript.execute(connection, new FileReader(fileLoc));
    }

    @Override
    public boolean isValid() throws SQLException {
        return connection.isValid(1000);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    private void createData() throws UnsupportedEncodingException, FileNotFoundException, SQLException {
        String fileLoc = getCreateDataScriptLocation();
        RunScript.execute(connection, new FileReader(fileLoc));
    }

    private String getCreateScriptLocation() throws UnsupportedEncodingException {
        return getScriptLocation(CREATESCRIPTNAME);
    }

    private String getCreateDataScriptLocation() throws UnsupportedEncodingException {
        return getScriptLocation(IMPORTDATASCRIPTNAME);
    }

    private String getDropDatabaseScriptLocation() throws UnsupportedEncodingException {
        return getScriptLocation(DROPSCRIPTNAME);
    }

    private String getScriptLocation(String file) throws UnsupportedEncodingException {
        String rawScriptLocation = this.getClass().getClassLoader().getResource(file).toString();
        return URLDecoder.decode(rawScriptLocation, ENCODINGTYPE).replace(REPLACEFILEFROMSTRING, BLANK);
    }
}
