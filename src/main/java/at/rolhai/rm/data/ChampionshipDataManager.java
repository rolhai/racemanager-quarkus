package at.rolhai.rm.data;

import at.rolhai.rm.championship.ChampionshipResultMapper;
import at.rolhai.rm.championship.db.*;
import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.driver.db.DriverRepository;
import at.rolhai.rm.core.event.db.EventEntity;
import at.rolhai.rm.core.event.db.EventRepository;
import at.rolhai.rm.core.season.SeasonMapper;
import at.rolhai.rm.core.season.db.SeasonEntity;
import at.rolhai.rm.core.season.db.SeasonRepository;
import at.rolhai.rm.core.team.db.TeamEntity;
import at.rolhai.rm.core.team.db.TeamRepository;
import at.rolhai.rm.data.championship.ChampionshipData;
import at.rolhai.rm.data.championship.ChampionshipEventData;
import at.rolhai.rm.data.championship.ChampionshipResultData;
import at.rolhai.rm.data.championship.ChampionshipTeamData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ChampionshipDataManager {

    private static final Logger LOGGER = Logger.getLogger(ChampionshipDataManager.class);

    private static final String DATA_DIR = "./data";

    private static final String FILTER_EXT = "championship-";

    @Inject
    DataFileManager dataFileManager;

    @Inject
    ChampionshipRepository championshipRepository;

    @Inject
    ChampionshipResultRepository championshipResultRepository;

    @Inject
    EventRepository eventRepository;

    @Inject
    DriverRepository driverRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    SeasonRepository seasonRepository;

    @Inject
    ChampionshipResultMapper championshipResultMapper;

    @Transactional
    public void importSeasons() {
        try {
            File[] files = getSeasonFiles();
            if (files == null) {
                return;
            }
            List<ChampionshipData> data = dataFileManager.loadFromFiles(files, ChampionshipData.class);
            LOGGER.info(String.format("init %d championships", data.size()));
            for (ChampionshipData championshipData : data) {
                // persist championship with events, team, drivers and results
                importChampionship(championshipData);
            }
        } catch (Exception ex) {
            LOGGER.error("load seasons failed", ex);
        }
    }

    private ChampionshipEntity importChampionship(ChampionshipData data) {
        ChampionshipEntity championshipEntity = new ChampionshipEntity();

        SeasonEntity seasonEntity = seasonRepository.findBySimulation(data.getSimulation(), data.getSeasonYear());
        championshipEntity.setSeason(seasonEntity);

        championshipEntity.setEvents(new ArrayList<>());
        for (ChampionshipEventData championshipEventData : data.getEvents()) {
            ChampionshipEventEntity entity = importChampionshipEvent(championshipEntity, championshipEventData);
            championshipEntity.getEvents().add(entity);
        }

        championshipEntity.setTeams(new ArrayList<>());
        for (ChampionshipTeamData championshipTeamData : data.getTeams()) {
            ChampionshipTeamEntity entity = importChampionshipTeam(championshipEntity, championshipTeamData);
            championshipEntity.getTeams().add(entity);
        }
        championshipRepository.persist(championshipEntity);

        for (ChampionshipResultData championshipResultData : data.getResults()) {
            importChampionshipResult(championshipEntity, championshipResultData);
        }
        return championshipEntity;
    }

    private ChampionshipTeamEntity importChampionshipTeam(ChampionshipEntity championshipEntity, ChampionshipTeamData data) {
        TeamEntity teamEntity = teamRepository.findByName(data.getTeamName());
        DriverEntity driver1Entity = driverRepository.findByDriverName(data.getDriver1Firstname(), data.getDriver1Lastname());
        DriverEntity driver2Entity = driverRepository.findByDriverName(data.getDriver2Firstname(), data.getDriver2Lastname());

        ChampionshipTeamEntity entity = new ChampionshipTeamEntity();
        entity.setChampionship(championshipEntity);
        entity.setTeam(teamEntity);
        entity.setDriver1(driver1Entity);
        entity.setDriver2(driver2Entity);
        entity.setOrderNumber(data.getOrderNumber());
        return entity;
    }

    private ChampionshipEventEntity importChampionshipEvent(ChampionshipEntity championship, ChampionshipEventData data) {
        EventEntity eventEntity = eventRepository.findByLocation(data.getLocation());

        ChampionshipEventEntity entity = new ChampionshipEventEntity();
        entity.setChampionship(championship);
        entity.setEvent(eventEntity);
        entity.setOrderNumber(data.getOrderNumber());
        return entity;
    }

    private void importChampionshipResult(ChampionshipEntity championshipEntity, ChampionshipResultData data) {
        DriverEntity driverEntity = driverRepository.findByDriverName(data.getDriverFirstname(), data.getDriverLastname());
        TeamEntity teamEntity = teamRepository.findByName(data.getTeamName());
        EventEntity eventEntity = eventRepository.findByLocation(data.getLocation());

        ChampionshipResultEntity entity = championshipResultMapper.mapToEntity(data);
        entity.setChampionship(championshipEntity);
        entity.setDriver(driverEntity);
        entity.setTeam(teamEntity);
        entity.setEvent(eventEntity);
        championshipResultRepository.persist(entity);
    }

    private File[] getSeasonFiles() {
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().toLowerCase().startsWith(FILTER_EXT);
            }
        };
        File dir = new File(DATA_DIR);
        return dir.listFiles(filter);
    }
}
