package nl.ica.oose.project.juke.playlistgetservice;

import com.codahale.metrics.annotation.Timed;
import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * The class where the http request ends up and gets processed
 *
 * @author Harm Tacoma
 */
@Path("/playlists")
public class PlaylistGetService {

    private IPlaylistGetServicePersistence database;

    /**
     * The constructor to instantiate this class
     *
     * @param database The database used to search in
     */
    public PlaylistGetService(IPlaylistGetServicePersistence database) {
        this.database = database;
    }

    /**
     * Method that is called when the website sends a request from the stated Path ("/getTracks/{userId}/{playlistId}")
     *
     * @param username   the name of the user sending the request
     * @param playlistId the id of the playlist the user wants to load
     * @return a JSON response with the results, in the form of a list of Tracks in the playlist
     */
    @GET
    @Path("/getTracks/{username}/{playlistId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getTracks(@PathParam("username") String username, @PathParam("playlistId") String playlistId) {
        int intPlaylistId = Integer.parseInt(playlistId);
        List<Track> tracks;

        try {
            int userId = database.getUserId(username);
            boolean authority = database.verifyUser(userId, intPlaylistId);
            if (!authority) return Response.status(401).entity("You are not authorized to view this playlist.").build();
            tracks = database.getTracks(intPlaylistId);
        } catch (SQLException e) {
            return Response.status(e.getErrorCode()).entity(e.getMessage()).build();
        } catch (NoResultFoundException e) {
            return Response.status(e.getCode()).entity(e.getMessage()).build();
        }
        return Response.ok(tracks).build();
    }

    /**
     * Method that is called when the website sends a request from the stated Path ("/getPlaylists/{userId}")
     *
     * @param username the name of the user responsible for the request
     * @return a JSON response with the results, in the form of a list of Playlists
     */
    @GET
    @Timed
    @Path("/getPlaylists/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@PathParam("username") String username) {
        List<Playlist> playlists;
        try {
            int userId = database.getUserId(username);
            playlists = database.getPlaylists(userId);
        } catch (SQLException e) {
            return Response.status(e.getErrorCode()).entity(e.getMessage()).build();
        } catch (NoResultFoundException e) {
            return Response.status(e.getCode()).entity(e.getMessage()).build();
        }
        return Response.ok(playlists).build();
    }
}
