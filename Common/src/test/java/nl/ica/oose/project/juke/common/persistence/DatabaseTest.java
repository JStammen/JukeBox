package nl.ica.oose.project.juke.common.persistence;

import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class DatabaseTest {
    private static final String IOEXCEPTIONMESSAGE = "IOException has been triggered.";
    private static final String SQLEXCEPTIONMESSAGE = "SQLException has been triggered.";
    private static final String FILENOTFOUNDEXCEPTIONMESSAGE = "FileNotFoundException has been triggered.";
    private static final String UNSUPPORTEDENCODINGEXCEPTIONMESSAGE = "UnsupportedEncodingException has been triggered.";
    private static final String CLASSNOTFOUNDEXCEPTIONMESSAGE = "ClassNotFoundException has been triggered.";

    private static final String THISSHOULDFAIL = "This Should Fail";

    private static final String DRIVER = "org.h2.Driver";
    private static final String SERVERLOCATION = "jdbc:h2:~/jukeboxtest";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private static final String REPLACEFILEFROMSTRING = "file:";
    private static final String BLANK = "";
    private static final String ENCODINGTYPE = "UTF-8";

    private Database fullDatabase;
    private IDatabaseConfig fullConfig;
    private Connection connection;

    @Before
    public void startUp() {
        this.fullConfig = new DatabaseConfigMock(DRIVER, SERVERLOCATION, USERNAME, PASSWORD);

        String fileLoc = "Not Initialized";
        try {
            fullDatabase = new Database(new H2Config());
            this.connection = fullDatabase.getConnection();

            fileLoc = getCreateScriptLocation();
            RunScript.execute(connection, new FileReader(fileLoc));

        } catch (IOException e) {
            fail(IOEXCEPTIONMESSAGE + " Error Number: 1 FileLocation: " + fileLoc);
        } catch (SQLException e) {
            fail(SQLEXCEPTIONMESSAGE + " Error Number: 2");
        } catch (ClassNotFoundException e) {
            fail(CLASSNOTFOUNDEXCEPTIONMESSAGE + " Error Number: 3");
        }
    }

    @Test(expected = SQLException.class)
    public void createNewInstanceShouldFailWithSQLException() throws SQLException, ClassNotFoundException {
        Database database = new Database(new DatabaseConfigMock(DRIVER, THISSHOULDFAIL, USERNAME, PASSWORD));
    }

    @Test
    public void isValidFullDatabaseShouldBeTrue() throws SQLException, ClassNotFoundException {
        this.fullDatabase = new Database(fullConfig);
        assertTrue(fullDatabase.isValid());
    }

    @After
    public void cleanUp() {
        String fileLoc = "Not Initialized.";
        try {
            fileLoc = getDropDatabaseScriptLocation();
            RunScript.execute(connection, new FileReader(fileLoc));
            connection.close();
        } catch (SQLException e) {
            fail(SQLEXCEPTIONMESSAGE + " Error Number: 4 FileLocation: " + fileLoc);
        } catch (FileNotFoundException e) {
            fail(FILENOTFOUNDEXCEPTIONMESSAGE + " Error Number: 5");
        } catch (UnsupportedEncodingException e) {
            fail(UNSUPPORTEDENCODINGEXCEPTIONMESSAGE + " Error Number: 6");
        }
    }

    private String getCreateScriptLocation() throws UnsupportedEncodingException {
        String rawScriptLocation = this.getClass().getClassLoader().getResource("createH2Database.sql").toString();
        return URLDecoder.decode(rawScriptLocation, ENCODINGTYPE).replace(REPLACEFILEFROMSTRING, BLANK);
    }

    private String getDropDatabaseScriptLocation() throws UnsupportedEncodingException {
        String rawScriptLocation = this.getClass().getClassLoader().getResource("dropH2Database.sql").toString();
        return URLDecoder.decode(rawScriptLocation, ENCODINGTYPE).replace(REPLACEFILEFROMSTRING, BLANK);
    }
}
