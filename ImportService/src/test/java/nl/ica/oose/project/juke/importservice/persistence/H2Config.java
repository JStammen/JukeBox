package nl.ica.oose.project.juke.importservice.persistence;

import nl.ica.oose.project.juke.common.persistence.IDatabaseConfig;
import org.apache.commons.lang.NotImplementedException;

public class H2Config implements IDatabaseConfig {

    private static final String DRIVER = "org.h2.Driver";

    private static final String SERVERLOCATION = "jdbc:h2:~/jukeboxtest";

    private static final String USERNAME = "";

    private static final String PASSWORD = "";

    @Override
    public String getServerlocation() {
        return SERVERLOCATION;
    }

    @Override
    public void setServerlocation(String serverlocation) {
        throw new NotImplementedException();
    }

    @Override
    public String getUsername() {
        return USERNAME;
    }

    @Override
    public void setUsername(String username) {
        throw new NotImplementedException();
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public void setPassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public String getDriver() {
        return DRIVER;
    }

    @Override
    public void setDriver(String driver) {
        throw new NotImplementedException();
    }
}
