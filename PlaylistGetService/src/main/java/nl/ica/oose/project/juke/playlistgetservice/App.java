package nl.ica.oose.project.juke.playlistgetservice;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ica.oose.project.juke.playlistgetservice.persistence.IPlaylistGetServicePersistence;
import nl.ica.oose.project.juke.playlistgetservice.persistence.PlaylistGetServiceConfig;
import nl.ica.oose.project.juke.playlistgetservice.persistence.PlaylistGetServicePersistence;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * The app to run the service PlaylistGetService with
 *
 * @author Harm Tacoma
 * @see io.dropwizard.Application
 */
public class App extends Application<PlaylistGetServiceConfig> {

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
        return "PlaylistGetService";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap<PlaylistGetServiceConfig> bootstrap) {
        bootstrap.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(PlaylistGetServiceConfig config, Environment environment) throws Exception {
        setCrossDomainResourceSharing(environment);
        IPlaylistGetServicePersistence database = new PlaylistGetServicePersistence(config);

        environment.healthChecks().register("PlaylistGetServiceHealthCheck", new PlaylistGetServiceHealthCheck(database));
        environment.jersey().register(new PlaylistGetService(database));
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
