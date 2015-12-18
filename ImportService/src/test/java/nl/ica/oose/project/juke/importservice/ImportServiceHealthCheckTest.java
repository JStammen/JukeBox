package nl.ica.oose.project.juke.importservice;

import com.codahale.metrics.health.HealthCheck;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceDatabaseMock;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceDatabaseMockUnhealthy;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceSftpMock;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceSftpMockUnhealthy;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportServiceHealthCheckTest {

    @Test
    public void createNewImportServiceHealthCheckShouldNotFail() {
        assertNotNull(new ImportServiceHealthCheck(new ImportServiceDatabaseMock(), new ImportServiceSftpMock()));
    }

    @Test(expected = NullPointerException.class)
    public void bothNull() {
        new ImportServiceHealthCheck(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void databaseNull() {
        new ImportServiceHealthCheck(null, new ImportServiceSftpMock());
    }

    @Test(expected = NullPointerException.class)
    public void sftpNull() {
        new ImportServiceHealthCheck(new ImportServiceDatabaseMock(), null);
    }

    @Test
    public void bothNullResponse() {
        try {
            new ImportServiceHealthCheck(null, null);
        } catch (NullPointerException e) {
            assertEquals("Both database and sftp are null.", e.getMessage());
        }
    }

    @Test
    public void databaseNullResponse() {
        try {
            new ImportServiceHealthCheck(null, new ImportServiceSftpMock());
        } catch (NullPointerException e) {
            assertEquals("Database argument was null.", e.getMessage());
        }
    }

    @Test
    public void sftpNullResponse() {
        try {
            new ImportServiceHealthCheck(new ImportServiceDatabaseMock(), null);
        } catch (NullPointerException e) {
            assertEquals("Sftp argument was null.", e.getMessage());
        }

    }

    @Test
    public void bothHealthyExpected() throws Exception {
        ImportServiceHealthCheck ishc = new ImportServiceHealthCheck(new ImportServiceDatabaseMock(), new ImportServiceSftpMock());
        HealthCheck.Result result = ishc.check();
        assertTrue(result.isHealthy());
        System.out.println(result.getMessage());
    }

    @Test
    public void databaseUnhealthyExpected() throws Exception {
        ImportServiceHealthCheck ishc = new ImportServiceHealthCheck(new ImportServiceDatabaseMockUnhealthy(), new ImportServiceSftpMock());
        HealthCheck.Result result = ishc.check();
        assertFalse(result.isHealthy());
        assertTrue("Database connection timed out.".equals(result.getMessage()));
    }

    @Test
    public void sftpUnhealthyExpected() throws Exception {
        ImportServiceHealthCheck ishc = new ImportServiceHealthCheck(new ImportServiceDatabaseMock(), new ImportServiceSftpMockUnhealthy());
        HealthCheck.Result result = ishc.check();
        assertFalse(result.isHealthy());
        assertTrue("FTP connection timed out.".equals(result.getMessage()));
    }

    @Test
    public void bothUnhealthyExpected() throws Exception {
        ImportServiceHealthCheck healthcheck = new ImportServiceHealthCheck(new ImportServiceDatabaseMockUnhealthy(), new ImportServiceSftpMockUnhealthy());
        HealthCheck.Result result = healthcheck.check();
        assertFalse(result.isHealthy());
        assertTrue("Both the FTP and Database connection timed out.".equals(result.getMessage()));
    }
}
