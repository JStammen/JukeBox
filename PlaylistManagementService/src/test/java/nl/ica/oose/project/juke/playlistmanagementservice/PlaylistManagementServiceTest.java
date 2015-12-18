package nl.ica.oose.project.juke.playlistmanagementservice;

import nl.ica.oose.project.juke.playlistmanagementservice.persistence.PlaylistManagementServicePersistenceMock;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.fail;

public class PlaylistManagementServiceTest {
    private static final int FIVE = 5;
    private static final String ELEVEN_TEXT = "11";
    private static final String NEWPLAYLISTNAME = "NAAM PLAYLIST 11";

    private PlaylistManagementService service;

    @Before
    public void startUp() {
        service = new PlaylistManagementService(new PlaylistManagementServicePersistenceMock());
    }

    @Test
    public void createNewPlaylistShouldNotFail() {
        Response response = service.createPlaylist(NEWPLAYLISTNAME, ELEVEN_TEXT);

        if (response.getStatus() != Response.Status.CREATED.getStatusCode())
            fail();
    }

    @Test
    public void deletePlaylistShouldNotFail() {
        Response response = service.deletePlaylist(FIVE);

        if (response.getStatus() != Response.Status.OK.getStatusCode())
            fail();
    }
}
