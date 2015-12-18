package nl.ica.oose.project.juke.playlistmanagementservice;

import com.codahale.metrics.annotation.Timed;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.IPlaylistManagementServicePersistence;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * The class where the http request ends up and gets processed.
 *
 * @author Paul Kamps
 * @author Kayan Meijer
 */
@Path("/playlist")
@Produces(MediaType.APPLICATION_JSON)
public class PlaylistManagementService {

    private IPlaylistManagementServicePersistence database;

    /**
     * The constructor used to create a new instance of this class.
     *
     * @param database The database used in this webservice.
     */
    public PlaylistManagementService(IPlaylistManagementServicePersistence database) {
        this.database = database;
    }

    /**
     * The web method used to create a new playlist.
     *
     * @param playlistName The name of the playlist.
     * @param userName     The name of the user.
     * @return Response
     */
    @POST
    @Timed
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createPlaylist(@FormParam("playlistName") String playlistName, @FormParam("userName") String userName) {
        try {
            database.createPlaylist(playlistName, userName);

            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException exception) {
            return Response.status(exception.getErrorCode()).entity(exception).build();
        }
    }

    /**
     * The web method used to delete a playlist.
     *
     * @param playlistID The id of the playlist.
     * @return Response
     */
    @POST
    @Timed
    @Path("/delete/{playlistid}")
    public Response deletePlaylist(@PathParam("playlistid") int playlistID) {
        try {
            database.deletePlaylist(playlistID);
            return Response.ok().build();
        } catch (SQLException exception) {
            return Response.status(exception.getErrorCode()).entity(exception).build();
        }
    }
}
