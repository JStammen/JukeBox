package nl.ica.oose.project.juke.importservice.persistence;

public class ImportServiceSftpMockUnhealthy extends ImportServiceSftpMock {

    @Override
    public boolean isValid() {
        return false;
    }
}
