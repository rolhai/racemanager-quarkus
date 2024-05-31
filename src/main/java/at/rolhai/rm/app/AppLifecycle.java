package at.rolhai.rm.app;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class AppLifecycle {

    private static final Logger LOGGER = Logger.getLogger(AppLifecycle.class);

    @ConfigProperty(name = "quarkus.application.version")
    String version;    

    void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("The application is starting...");
        LOGGER.info("profile: " + ProfileManager.getLaunchMode().getDefaultProfile());
        LOGGER.info("version: " + version);
    }

    void onStop(@Observes ShutdownEvent ev) {               
        LOGGER.info("The application is stopping...");
    }
    
}
