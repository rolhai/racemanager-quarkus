package at.rolhai.rm.data;

import at.rolhai.rm.core.country.CountryMapper;
import at.rolhai.rm.core.country.db.CountryEntity;
import at.rolhai.rm.core.country.db.CountryRepository;
import at.rolhai.rm.core.season.SeasonMapper;
import at.rolhai.rm.core.season.db.SeasonEntity;
import at.rolhai.rm.core.season.db.SeasonRepository;
import at.rolhai.rm.data.core.*;
import at.rolhai.rm.core.driver.DriverMapper;
import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.driver.db.DriverRepository;
import at.rolhai.rm.core.event.EventMapper;
import at.rolhai.rm.core.event.db.EventEntity;
import at.rolhai.rm.core.event.db.EventRepository;
import at.rolhai.rm.core.team.TeamMapper;
import at.rolhai.rm.core.team.db.TeamEntity;
import at.rolhai.rm.core.team.db.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class CoreDataManager {

    private static final Logger LOGGER = Logger.getLogger(CoreDataManager.class);

    private static final String DATA_FILEPATH = "./data/core_data.json";

    @Inject
    DataFileManager dataFileManager;

    @Inject
    DriverRepository driverRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    EventRepository eventRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    SeasonRepository seasonRepository;

    @Inject
    DriverMapper driverMapper;

    @Inject
    TeamMapper teamMapper;

    @Inject
    EventMapper eventMapper;

    @Inject
    CountryMapper countryMapper;

    @Inject
    SeasonMapper seasonMapper;

    @Transactional
    public void importCoreData() {
        try {
            CoreData coreData = dataFileManager.loadFromFile(DATA_FILEPATH, CoreData.class);
            importSeasons(coreData.getSeasons());
            importCountries(coreData.getCountries());
            importDrivers(coreData.getDrivers());
            importTeams(coreData.getTeams());
            importEvents(coreData.getEvents());
        } catch (Exception ex) {
            LOGGER.error("load core data failed", ex);
        }
    }

    public void exportCoreData() {
        try {
            CoreData coreData = new CoreData();
            exportSeasons(coreData);
            exportCountries(coreData);
            exportDrivers(coreData);
            exportTeams(coreData);
            exportEvents(coreData);
            dataFileManager.saveToFile(DATA_FILEPATH, coreData);
        } catch (Exception ex) {
            LOGGER.error("save core data failed", ex);
        }
    }

    private void importSeasons(List<SeasonData> data) {
        if (data == null) {
            return;
        }
        List<SeasonEntity> entities = seasonMapper.mapToEntities(data);
        seasonRepository.persist(entities);
        LOGGER.info(String.format("import %d seasons", entities.size()));
    }

    private void importDrivers(List<DriverData> data) {
        if (data == null) {
            return;
        }
        List<DriverEntity> entities = driverMapper.mapToEntities(data);
        driverRepository.persist(entities);
        LOGGER.info(String.format("import %d drivers", entities.size()));
    }

    private void importTeams(List<TeamData> data) {
        if (data == null) {
            return;
        }
        List<TeamEntity> entities = teamMapper.mapToEntities(data);
        teamRepository.persist(entities);
        LOGGER.info(String.format("import %d teams", entities.size()));
    }

    private void importEvents(List<EventData> data) {
        if (data == null) {
            return;
        }
        List<EventEntity> entities = eventMapper.mapToEntities(data);
        eventRepository.persist(entities);
        LOGGER.info(String.format("import %d events", entities.size()));
    }

    private void importCountries(List<CountryData> data) {
        if (data == null) {
            return;
        }
        List<CountryEntity> entities = countryMapper.mapToEntities(data);
        countryRepository.persist(entities);
        LOGGER.info(String.format("import %d countries", entities.size()));
    }

    private void exportSeasons(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<SeasonEntity> entities = seasonRepository.listAll();
        List<SeasonData> data = seasonMapper.mapToData(entities);
        coreData.setSeasons(data);
        LOGGER.info(String.format("export %d seasons", data.size()));
    }

    private void exportDrivers(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<DriverEntity> entities = driverRepository.listAll();
        List<DriverData> data = driverMapper.mapToData(entities);
        coreData.setDrivers(data);
        LOGGER.info(String.format("export %d drivers", data.size()));
    }

    private void exportTeams(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<TeamEntity> entities = teamRepository.listAll();
        List<TeamData> data = teamMapper.mapToData(entities);
        coreData.setTeams(data);
        LOGGER.info(String.format("export %d teams", data.size()));
    }

    private void exportEvents(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<EventEntity> entities = eventRepository.listAll();
        List<EventData> data = eventMapper.mapToData(entities);
        coreData.setEvents(data);
        LOGGER.info(String.format("export %d events", data.size()));
    }

    private void exportCountries(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<CountryEntity> entities = countryRepository.listAll();
        List<CountryData> data = countryMapper.mapToData(entities);
        coreData.setCountries(data);
        LOGGER.info(String.format("export %d countries", data.size()));
    }
}
