package nl.ica.oose.project.juke.playlistmanagementservice;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.IPlaylistManagementServicePersistence;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.PlaylistManagementServiceConfig;
import nl.ica.oose.project.juke.playlistmanagementservice.persistence.PlaylistManagementServicePersistence;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * The app to run the service PlaylistManagementService with
 *
 * @author Paul Kamps
 * @author Kayan Meijer
 * @see io.dropwizard.Application
 */
public class App extends Application<PlaylistManagementServiceConfig> {

    /**
     * The main method for this service
     *
     * @param args the configuration file aswell as server are expected here
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "playlistManagementService";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap<PlaylistManagementServiceConfig> bootstrap) {
        bootstrap.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(PlaylistManagementServiceConfig configuration, Environment environment) throws Exception {
        setCrossDomainResourceSharing(environment);

        IPlaylistManagementServicePersistence database = new PlaylistManagementServicePersistence(configuration);

        environment.healthChecks().register("PlaylistManagementServiceHealthCheck", new PlaylistManagementHealthCheck(database));
        environment.jersey().register(new PlaylistManagementService(database));
    }

    private void setCrossDomainResourceSharing(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
