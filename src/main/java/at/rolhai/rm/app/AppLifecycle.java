package at.rolhai.rm.app;

import at.rolhai.rm.data.CoreDataManager;
import at.rolhai.rm.data.ChampionshipDataManager;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class AppLifecycle {

    private static final Logger LOGGER = Logger.getLogger(AppLifecycle.class);

    @ConfigProperty(name = "quarkus.application.version")
    String version;

    @ConfigProperty(name = "quarkus.profile")
    String profile;

    @Inject
    CoreDataManager coreDataManager;

    @Inject
    ChampionshipDataManager championshipDataManager;

    void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("The application is starting...");
        LOGGER.info("profile: " + profile);
        LOGGER.info("version: " + version);
        coreDataManager.importCoreData();
        championshipDataManager.importSeasons();
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");

    }
    
}
