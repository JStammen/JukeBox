package nl.ica.oose.project.juke.rateservice.persistence;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RateServiceConfigTest {

    private final static String DRIVER = "driver";
    private final static String LOCATION = "location";
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";

    private final static String MODIFIED_DRIVER = "modified_driver";
    private final static String MODIFIED_LOCATION = "modified_location";
    private final static String MODIFIED_USERNAME = "modified_username";
    private final static String MODIFIED_PASSWORD = "modified_password";

    RateServiceConfig fullConfig;
    RateServiceConfig blankConfig;

    @Before
    public void startUp() {
        fullConfig = new RateServiceConfig(DRIVER, LOCATION, USERNAME, PASSWORD);
        blankConfig = new RateServiceConfig();
    }

    @Test
    public void shouldReturnDriver() {
        assertEquals(fullConfig.getDriver(), DRIVER);
    }

    @Test
    public void shoudReturnModifiedDriver() {
        fullConfig.setDriver(MODIFIED_DRIVER);
        assertEquals(fullConfig.getDriver(), MODIFIED_DRIVER);
    }

    @Test
    public void shouldReturnNullIfDriverIsEmpty() {
        assertNull(blankConfig.getDriver());
    }

    @Test
    public void shouldReturnLocation() {
        assertEquals(fullConfig.getServerlocation(), LOCATION);
    }

    @Test
    public void shoudReturnModifiedLocation() {
        fullConfig.setServerlocation(MODIFIED_LOCATION);
        assertEquals(fullConfig.getServerlocation(), MODIFIED_LOCATION);
    }

    @Test
    public void shouldReturnNullIfLocationIsEmpty() {
        assertNull(blankConfig.getServerlocation());
    }

    @Test
    public void shouldReturnUsername() {
        assertEquals(fullConfig.getUsername(), USERNAME);
    }

    @Test
    public void shoudReturnModifiedUsername() {
        fullConfig.setUsername(MODIFIED_USERNAME);
        assertEquals(fullConfig.getUsername(), MODIFIED_USERNAME);
    }

    @Test
    public void shouldReturnNullIfUsernameIsEmpty() {
        assertNull(blankConfig.getUsername());
    }

    @Test
    public void shouldReturnPassword() {
        assertEquals(fullConfig.getPassword(), PASSWORD);
    }

    @Test
    public void shoudReturnModifiedPassword() {
        fullConfig.setPassword(MODIFIED_PASSWORD);
        assertEquals(fullConfig.getPassword(), MODIFIED_PASSWORD);
    }

    @Test
    public void shouldReturnNullIfPasswordIsEmpty() {
        assertNull(blankConfig.getPassword());
    }
}
