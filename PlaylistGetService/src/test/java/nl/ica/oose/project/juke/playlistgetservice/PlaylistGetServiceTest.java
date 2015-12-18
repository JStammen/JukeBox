package nl.ica.oose.project.juke.playlistgetservice;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.playlistgetservice.Persistence.PlaylistGetServiceDatabaseMock;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaylistGetServiceTest {

    private static final String GOODUSERNAME = "Harm";
    private static final String BADUSERNAME = "Robbert";
    private static final String UNAUTHORIZEDUSERNAME = "Kayak";

    private static final String GOODPLAYLISTID = "1";
    private static final String BADPLAYLISTID = "8";

    private PlaylistGetService service;

    @Before
    public void init() {
        this.service = new PlaylistGetService(new PlaylistGetServiceDatabaseMock());
    }

    @Test
    public void userOneHasTwoPlaylists() {
        List<Playlist> playlists = (List<Playlist>) service.getPlaylists(GOODUSERNAME).getEntity();
        assertEquals(playlists.size(), 2);
    }

    @Test
    public void userFiveHasNoPlaylists() {
        Response response = service.getPlaylists(BADUSERNAME);
        assertEquals(response.getStatus(), 404);
    }

    @Test
    public void userHasNoAuthority() {
        Response response = service.getTracks(UNAUTHORIZEDUSERNAME, GOODPLAYLISTID);
        assertEquals(response.getStatus(), 401);
    }

    @Test
    public void playlistDoesNotExist() {
        Response response = service.getTracks(GOODUSERNAME, BADPLAYLISTID);
        assertEquals(response.getStatus(), 401);
    }

    @Test
    public void nonExistingUsername() {
        Response response = service.getTracks(BADUSERNAME, GOODPLAYLISTID);
        assertEquals(response.getStatus(), 404);
    }

    @Test
    public void getTracksActuallySucceeds() {
        List<Track> tracks = (List<Track>) service.getTracks(GOODUSERNAME, GOODPLAYLISTID).getEntity();
        assertEquals(tracks.size(), 2);
    }
}
