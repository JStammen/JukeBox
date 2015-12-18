package nl.ica.oose.project.juke.common.persistence;

public class DatabaseConfigMock implements IDatabaseConfig {

    private String driver;
    private String serverLocation;
    private String userName;
    private String password;

    public DatabaseConfigMock() {
    }

    public DatabaseConfigMock(String driver, String serverLocation, String userName, String password) {
        this.driver = driver;
        this.serverLocation = serverLocation;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getServerlocation() {
        return this.serverLocation;
    }

    @Override
    public void setServerlocation(String serverlocation) {
        this.serverLocation = serverlocation;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public void setUsername(String username) {
        this.userName = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
