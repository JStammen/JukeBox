package nl.ica.oose.project.juke.rateservice;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ica.oose.project.juke.rateservice.persistence.IRateServicePersistence;
import nl.ica.oose.project.juke.rateservice.persistence.RateServiceConfig;
import nl.ica.oose.project.juke.rateservice.persistence.RateServicePersistence;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * The main class of the rateservice
 *
 * @author Jop Stammen
 * @see io.dropwizard.Application
 */
public class App extends Application<RateServiceConfig> {

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
        return "rateService";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap bootstrap) {
        bootstrap.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(RateServiceConfig configuration, Environment environment) throws Exception {
        setCrossDomainResourceSharing(environment);

        IRateServicePersistence database = new RateServicePersistence(configuration);

        environment.healthChecks().register("RateServiceHealthCheck", new RateServiceHealthCheck(database));
        environment.jersey().register(new RateService(database));
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
