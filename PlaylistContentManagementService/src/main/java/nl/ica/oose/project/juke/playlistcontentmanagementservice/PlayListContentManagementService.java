package nl.ica.oose.project.juke.playlistcontentmanagementservice;

import com.codahale.metrics.annotation.Timed;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.IPlayListContentManagementServicePersistence;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * The class where the http request ends up and gets processed
 *
 * @author Jop Stammen
 */
@Path("/content")
public class PlayListContentManagementService {

    private IPlayListContentManagementServicePersistence database;
    private static final String DATABASEARGUMENTNULLMESSAGE = "Database argument was null.";

    /**
     * The constructor for PlayListContentMangementService. The class for the Database is initialized here
     *
     * @param database The database used to search in
     */
    public PlayListContentManagementService(IPlayListContentManagementServicePersistence database) {
        if (database == null)
            throw new NullPointerException(DATABASEARGUMENTNULLMESSAGE);
        this.database = database;
    }

    /**
     * The web method used to add tracks to a playlist
     *
     * @param playlistID The ID of the playlist
     * @param trackID    The ID of the track.
     * @return Response
     */
    @POST
    @Timed
    @Path("/delete/{playlistID}/{trackID}")
    public Response deleteTrackOnPlaylist(@PathParam("playlistID") int playlistID, @PathParam("trackID") int trackID) {
        try {
            database.deleteTrackOnPlaylist(playlistID, trackID);
            return Response.ok().build();
        } catch (SQLException exception) {
            return Response.status(exception.getErrorCode()).entity(exception).build();
        }
    }

    /**
     * The web method for deleting a track from a playlist
     *
     * @param playlistID The ID of the playlist
     * @param trackID    The ID of the track
     * @return Response
     */
    @POST
    @Timed
    @Path("/add/{playlistID}/{trackID}")
    public Response addTrackToPlaylist(@PathParam("playlistID") int playlistID, @PathParam("trackID") int trackID) {
        try {
            database.addTrackOnPlaylist(playlistID, trackID);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException exception) {
            return Response.status(exception.getErrorCode()).entity(exception).build();
        }
    }
}
