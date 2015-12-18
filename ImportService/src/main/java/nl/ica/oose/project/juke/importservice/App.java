package nl.ica.oose.project.juke.importservice;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ica.oose.project.juke.importservice.persistence.*;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * The app to run the ImportService with
 *
 * @author Paul Kamps
 * @author Robbert de Wilde
 * @see io.dropwizard.Application
 */
public class App extends Application<ImportServiceConfig> {

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
        return "importService";
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
    public void run(ImportServiceConfig config, Environment environment) throws Exception {
        setCrossDomainResourceSharing(environment);
        IImportServicePersistence database = new ImportServicePersistence(config);
        IImportServiceSftp sftp = new ImportServiceSftp(config);
        environment.healthChecks().register("ImportServiceHealthCheck", new ImportServiceHealthCheck(database, sftp));
        environment.jersey().register(new ImportService(database, sftp));
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
