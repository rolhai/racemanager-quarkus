package at.rolhai.rm.data;

import at.rolhai.rm.country.CountryMapper;
import at.rolhai.rm.country.db.CountryEntity;
import at.rolhai.rm.country.db.CountryRepository;
import at.rolhai.rm.data.core.*;
import at.rolhai.rm.driver.DriverMapper;
import at.rolhai.rm.driver.db.DriverEntity;
import at.rolhai.rm.driver.db.DriverRepository;
import at.rolhai.rm.event.EventMapper;
import at.rolhai.rm.event.db.EventEntity;
import at.rolhai.rm.event.db.EventRepository;
import at.rolhai.rm.team.TeamMapper;
import at.rolhai.rm.team.db.TeamEntity;
import at.rolhai.rm.team.db.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class CoreDataManager {

    private static final Logger LOGGER = Logger.getLogger(CoreDataManager.class);

    private static final String DATA_FILEPATH = "./data/core.data";

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
    DriverMapper driverMapper;

    @Inject
    TeamMapper teamMapper;

    @Inject
    EventMapper eventMapper;

    @Inject
    CountryMapper countryMapper;

    @Transactional
    public void initializeCoreData() {
        try {
            CoreData coreData = dataFileManager.loadFromFile(DATA_FILEPATH, CoreData.class);
            initializeCountries(coreData.getCountries());
            initializeDrivers(coreData.getDrivers());
            initializeTeams(coreData.getTeams());
            initializeEvents(coreData.getEvents());
        } catch (Exception ex) {
            LOGGER.error("load core data failed", ex);
        }
    }

    public void updateCoreData() {
        try {
            CoreData coreData = new CoreData();
            updateCountries(coreData);
            updateDrivers(coreData);
            updateTeams(coreData);
            updateEvents(coreData);
            dataFileManager.saveToFile(DATA_FILEPATH, coreData);
        } catch (Exception ex) {
            LOGGER.error("save core data failed", ex);
        }
    }

    private void initializeDrivers(List<DriverData> data) {
        if (data == null) {
            return;
        }
        List<DriverEntity> entities = driverMapper.mapToEntities(data);
        driverRepository.persist(entities);
        LOGGER.info(String.format("init %d drivers", entities.size()));
    }

    private void initializeTeams(List<TeamData> data) {
        if (data == null) {
            return;
        }
        List<TeamEntity> entities = teamMapper.mapToEntities(data);
        teamRepository.persist(entities);
        LOGGER.info(String.format("init %d teams", entities.size()));
    }

    private void initializeEvents(List<EventData> data) {
        if (data == null) {
            return;
        }
        List<EventEntity> entities = eventMapper.mapToEntities(data);
        eventRepository.persist(entities);
        LOGGER.info(String.format("init %d events", entities.size()));
    }

    private void initializeCountries(List<CountryData> data) {
        if (data == null) {
            return;
        }
        List<CountryEntity> entities = countryMapper.mapToEntities(data);
        countryRepository.persist(entities);
        LOGGER.info(String.format("init %d countries", entities.size()));
    }

    private void updateDrivers(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<DriverEntity> entities = driverRepository.listAll();
        List<DriverData> data = driverMapper.mapToData(entities);
        coreData.setDrivers(data);
        LOGGER.info(String.format("update %d drivers", data.size()));
    }

    private void updateTeams(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<TeamEntity> entities = teamRepository.listAll();
        List<TeamData> data = teamMapper.mapToData(entities);
        coreData.setTeams(data);
        LOGGER.info(String.format("update %d teams", data.size()));
    }

    private void updateEvents(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<EventEntity> entities = eventRepository.listAll();
        List<EventData> data = eventMapper.mapToData(entities);
        coreData.setEvents(data);
        LOGGER.info(String.format("update %d events", data.size()));
    }

    private void updateCountries(CoreData coreData) {
        if (coreData == null) {
            return;
        }
        List<CountryEntity> entities = countryRepository.listAll();
        List<CountryData> data = countryMapper.mapToData(entities);
        coreData.setCountries(data);
        LOGGER.info(String.format("update %d countries", data.size()));
    }
}
