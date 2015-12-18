package nl.ica.oose.project.juke.playlistcontentmanagementservice;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.IPlayListContentManagementServicePersistence;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.PlayListContentManagementServiceConfig;
import nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence.PlayListContentManagementServicePersistence;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * The app to run the service PlaylistGetService with
 *
 * @author Harm Tacoma
 * @author Jop Stammen
 * @see io.dropwizard.Application
 */
public class App extends Application<PlayListContentManagementServiceConfig> {

    /**
     * The main method for this service
     *
     * @param args the configuration file and server argument are expected here
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
        return "playListContentManagementService";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap<PlayListContentManagementServiceConfig> bootstrap) {
        bootstrap.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(PlayListContentManagementServiceConfig config, Environment environment) throws Exception {
        setCrossDomainResourceSharing(environment);

        IPlayListContentManagementServicePersistence database = new PlayListContentManagementServicePersistence(config);

        environment.healthChecks().register("playListContentManagementServiceHealthCheck", new PlayListContentManagementServiceHealthCheck(database));
        environment.jersey().register(new PlayListContentManagementService(database));
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
