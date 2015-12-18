package nl.ica.oose.project.juke.rateservice;

import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.rateservice.persistence.IRateServicePersistence;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * A class that processes the websites request
 *
 * @author Robbert de Wilde
 * @author Jop Stammen
 * @author Kayan Meijer
 */
@Path("/rate")
public class RateService {

    private IRateServicePersistence database;

    /**
     * Constructor for the initialization.
     *
     * @param database contains the database information
     */
    public RateService(IRateServicePersistence database) {
        this.database = database;
    }

    /**
     * Method that gets the variable of the jukebox website.
     *
     * @param rating   the value that is submitted on the website
     * @param username the user that submitted the rating
     * @param trackID  the track that is getting rated
     * @return response of the trackID to website
     * @throws java.io.IOException
     * @throws nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException
     * @throws java.sql.SQLException
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response rateTrack(@FormParam("selectrating") String rating, @FormParam("userName") String username, @FormParam("trackID") String trackID) throws IOException, NoResultFoundException, SQLException {
        int intRating = Integer.parseInt(rating);
        int intTrackID = Integer.parseInt(trackID);
        database.rateTrack(intRating, username, intTrackID);
        return Response.ok(trackID).build();
    }

    /**
     * ]
     * Method that gets rating average
     *
     * @param trackID is the track where the average is being asked for
     * @return average to website
     */
    @GET
    @Path("/average/{trackID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAverage(@PathParam("trackID") int trackID) {
        int average;

        try {
            average = database.getAverage(trackID);
        } catch (SQLException e) {
            return Response.status(e.getErrorCode()).entity(e.getMessage()).build();
        }

        return Response.ok(average).build();
    }

    /**
     * Method that gets the rating for a track
     *
     * @param trackID  is the track what the rating is asked for
     * @param username the user who wants the rating
     * @return rating to website
     */
    @GET
    @Path("/userRating/{trackID}/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRating(@PathParam("trackID") int trackID, @PathParam("userName") String username) {
        int rating;
        try {
            rating = database.getRating(trackID, username);
        } catch (SQLException e) {
            return Response.status(e.getErrorCode()).entity(e.getMessage()).build();
        }
        return Response.ok(rating).build();
    }
}
