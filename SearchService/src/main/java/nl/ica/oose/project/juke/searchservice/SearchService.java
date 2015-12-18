package nl.ica.oose.project.juke.searchservice;

import com.codahale.metrics.annotation.Timed;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.persistence.exceptions.NoResultFoundException;
import nl.ica.oose.project.juke.searchservice.persistence.ISearchServicePersistence;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * The class where the http request ends up and gets processed
 *
 * @author Kayan Meijer
 * @author Jop Stammen
 */
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchService {

    private ISearchServicePersistence database;

    /**
     * The constructor for searchservice. The class for the Database is initialized here
     *
     * @param database The database used to search in
     */
    public SearchService(ISearchServicePersistence database) {
        this.database = database;
    }

    /**
     * A method where the REST request get processed
     *
     * @param criteria the variable to search upon
     * @return a JSON response with the results
     */
    @GET
    @Timed
    public Response search(@QueryParam("criteria") String criteria) {
        List<Track> tracks;
        try {
            tracks = database.search(criteria);
        } catch (SQLException e) {
            return Response.status(e.getErrorCode()).entity(e.getMessage()).build();
        } catch (NoResultFoundException e) {
            return Response.status(e.getCode()).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
        }
        return Response.ok(tracks).build();
    }
}
