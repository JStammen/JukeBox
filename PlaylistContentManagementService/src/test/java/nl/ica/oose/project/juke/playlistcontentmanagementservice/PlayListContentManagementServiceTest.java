package nl.ica.oose.project.juke.playlistcontentmanagementservice;

import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.PlayListContentManagementServicePersistenceMock;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.fail;

public class PlayListContentManagementServiceTest {
    private static final int playlistID = 1;
    private static final int trackID = 1;

    private PlayListContentManagementService playListContentManagementService;

    @Before
    public void startUp() {
        this.playListContentManagementService = new PlayListContentManagementService(new PlayListContentManagementServicePersistenceMock());
    }

    @Test
    public void addTrackToPlaylistShouldNotFail() {
        Response response = playListContentManagementService.addTrackToPlaylist(playlistID, trackID);

        if (response.getStatus() != Response.Status.CREATED.getStatusCode())
            fail();
    }

    @Test
    public void deleteTrackFromPlaylistShouldNotFail() {
        Response response = playListContentManagementService.deleteTrackOnPlaylist(playlistID, trackID);

        if (response.getStatus() != Response.Status.OK.getStatusCode())
            fail();
    }
}
