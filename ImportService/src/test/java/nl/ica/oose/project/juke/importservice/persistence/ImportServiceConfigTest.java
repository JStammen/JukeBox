package nl.ica.oose.project.juke.importservice.persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ImportServiceConfigTest {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "datasolutions";
    private static final String password = "jukebox";
    private static final String serverlocation = "jdbc:mysql://192.168.0.105/jukebox";
    private static final String sftphost = "192.168.0.101";
    private static final int sftpport = 22;
    private static final String sftpuser = "pi";
    private static final String sftppass = "raspberry";
    private static final String sftpworkingdir = "/home/pi/MusicLibrary";
    private static final String sftptempdir = "temp/";
    private static final String httpserverdir = "/var/www";

    private final static String MODIFIED_DRIVER = "modified_driver";
    private final static String MODIFIED_LOCATION = "modified_location";
    private final static String MODIFIED_USERNAME = "modified_username";
    private final static String MODIFIED_PASSWORD = "modified_password";
    private static final String MODIFIED_SFTPHOST = "modified_sftphost";
    private static final int MODIFIED_SFTPPORT = 23;
    private static final String MODIFIED_SFTPUSER = "modified_sftpuser";
    private static final String MODIFIED_SFTPPASS = "modfied_sftppass";
    private static final String MODIFIED_SFTPWORKINGDIR = "modified_sftpworkingdir";
    private static final String MODIFIED_SFTPTEMPDIR = "modified_sftptempdir";
    private static final String MODIFIED_HTTPSERVERDIR = "modified_httpserverdir";

    ImportServiceConfig basicConfig;
    ImportServiceConfig fullConfig;

    @Before
    public void init() {
        basicConfig = new ImportServiceConfig();
        fullConfig = new ImportServiceConfig(serverlocation, username, password, driver, sftphost, sftpport, sftpuser, sftppass, sftpworkingdir, sftptempdir, httpserverdir);
    }

    @Test
    public void shouldReturnDriver() {
        assertEquals(fullConfig.getDriver(), driver);
    }

    @Test
    public void shoudReturnModifiedDriver() {
        fullConfig.setDriver(MODIFIED_DRIVER);
        assertEquals(fullConfig.getDriver(), MODIFIED_DRIVER);
    }

    @Test
    public void shouldReturnNullIfDriverIsEmpty() {
        assertNull(basicConfig.getDriver());
    }

    @Test
    public void shouldReturnLocation() {
        assertEquals(fullConfig.getServerlocation(), serverlocation);
    }

    @Test
    public void shoudReturnModifiedLocation() {
        fullConfig.setServerlocation(MODIFIED_LOCATION);
        assertEquals(fullConfig.getServerlocation(), MODIFIED_LOCATION);
    }

    @Test
    public void shouldReturnNullIfLocationIsEmpty() {
        assertNull(basicConfig.getServerlocation());
    }

    @Test
    public void shouldReturnUsername() {
        assertEquals(fullConfig.getUsername(), username);
    }

    @Test
    public void shoudReturnModifiedUsername() {
        fullConfig.setUsername(MODIFIED_USERNAME);
        assertEquals(fullConfig.getUsername(), MODIFIED_USERNAME);
    }

    @Test
    public void shouldReturnNullIfUsernameIsEmpty() {
        assertNull(basicConfig.getUsername());
    }

    @Test
    public void shouldReturnPassword() {
        assertEquals(fullConfig.getPassword(), password);
    }

    @Test
    public void shoudReturnModifiedPassword() {
        fullConfig.setPassword(MODIFIED_PASSWORD);
        assertEquals(fullConfig.getPassword(), MODIFIED_PASSWORD);
    }

    @Test
    public void shouldReturnNullIfPasswordIsEmpty() {
        assertNull(basicConfig.getPassword());
    }

    @Test
    public void shouldReturnSftphost() {
        assertEquals(fullConfig.getSftphost(), sftphost);
    }

    @Test
    public void shoudReturnModifiedSftphost() {
        fullConfig.setSftphost(MODIFIED_SFTPHOST);
        assertEquals(fullConfig.getSftphost(), MODIFIED_SFTPHOST);
    }

    @Test
    public void shouldReturnNullIfSftphostIsEmpty() {
        assertNull(basicConfig.getSftphost());
    }

    @Test
    public void shouldReturnSftpport() {
        assertEquals(fullConfig.getSftpport(), sftpport);
    }

    @Test
    public void shoudReturnModifiedSftpport() {
        fullConfig.setSftpport(MODIFIED_SFTPPORT);
        assertEquals(fullConfig.getSftpport(), MODIFIED_SFTPPORT);
    }

    @Test
    public void shouldReturnZeroIfSftpportIsEmpty() {
        assertEquals(basicConfig.getSftpport(), 0);
    }

    @Test
    public void shouldReturnSftpuser() {
        assertEquals(fullConfig.getSftpuser(), sftpuser);
    }

    @Test
    public void shoudReturnModifiedSftpuser() {
        fullConfig.setSftpuser(MODIFIED_SFTPUSER);
        assertEquals(fullConfig.getSftpuser(), MODIFIED_SFTPUSER);
    }

    @Test
    public void shouldReturnNullIfSftpuserIsEmpty() {
        assertNull(basicConfig.getSftpuser());
    }

    @Test
    public void shouldReturnSftppass() {
        assertEquals(fullConfig.getSftppass(), sftppass);
    }

    @Test
    public void shoudReturnModifiedSftppass() {
        fullConfig.setSftppass(MODIFIED_SFTPPASS);
        assertEquals(fullConfig.getSftppass(), MODIFIED_SFTPPASS);
    }

    @Test
    public void shouldReturnNullIfSftppassIsEmpty() {
        assertNull(basicConfig.getSftppass());
    }

    @Test
    public void shouldReturnSftpworkingdir() {
        assertEquals(fullConfig.getWorkingdir(), sftpworkingdir);
    }

    @Test
    public void shoudReturnModifiedSftpworkingdir() {
        fullConfig.setWorkingdir(MODIFIED_SFTPWORKINGDIR);
        assertEquals(fullConfig.getWorkingdir(), MODIFIED_SFTPWORKINGDIR);
    }

    @Test
    public void shouldReturnNullIfSftpworkingdirIsEmpty() {
        assertNull(basicConfig.getWorkingdir());
    }

    @Test
    public void shouldReturnSftptempdir() {
        assertEquals(fullConfig.getTempdir(), sftptempdir);
    }

    @Test
    public void shoudReturnModifiedSftptempdir() {
        fullConfig.setTempdir(MODIFIED_SFTPTEMPDIR);
        assertEquals(fullConfig.getTempdir(), MODIFIED_SFTPTEMPDIR);
    }

    @Test
    public void shouldReturnNullIfSftptempdirIsEmpty() {
        assertNull(basicConfig.getTempdir());
    }

    @Test
    public void shouldReturnHttpserverdir() {
        assertEquals(fullConfig.getHttpserverdir(), httpserverdir);
    }

    @Test
    public void shoudReturnModifiedHttpserverdir() {
        fullConfig.setHttpserverdir(MODIFIED_HTTPSERVERDIR);
        assertEquals(fullConfig.getHttpserverdir(), MODIFIED_HTTPSERVERDIR);
    }

    @Test
    public void shouldReturnNullIfHttpserverdirIsEmpty() {
        assertNull(basicConfig.getHttpserverdir());
    }
}
