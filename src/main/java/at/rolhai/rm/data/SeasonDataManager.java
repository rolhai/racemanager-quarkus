package at.rolhai.rm.data;

import at.rolhai.rm.data.season.SeasonData;
import at.rolhai.rm.result.RaceResultMapper;
import at.rolhai.rm.result.db.RaceResultEntity;
import at.rolhai.rm.result.db.RaceResultRepository;
import at.rolhai.rm.season.SeasonMapper;
import at.rolhai.rm.season.db.SeasonEntity;
import at.rolhai.rm.season.db.SeasonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

@ApplicationScoped
public class SeasonDataManager {

    private static final Logger LOGGER = Logger.getLogger(SeasonDataManager.class);

    private static final String DATA_DIR = "./data";

    private static final String FILTER_EXT = ".season";

    @Inject
    DataFileManager dataFileManager;

    @Inject
    SeasonRepository seasonRepository;

    @Inject
    RaceResultRepository raceResultRepository;

    @Inject
    SeasonMapper seasonMapper;

    @Inject
    RaceResultMapper raceResultMapper;

    @Transactional
    public void initializeSeasons() {
        try {
            File[] files = getSeasonFiles();
            if (files == null) {
                return;
            }
            List<SeasonData> data = dataFileManager.loadFromFiles(files, SeasonData.class);
            List<SeasonEntity> entities = seasonMapper.mapToEntities(data);
            LOGGER.info(String.format("init %d seasons", entities.size()));
            for (SeasonData seasonData : data) {
                // persist season
                SeasonEntity seasonEntity = seasonMapper.mapToEntity(seasonData);
                seasonRepository.persist(seasonEntity);

                // persist race results
                List<RaceResultEntity> raceResultEntities = raceResultMapper.mapToEntities(seasonData.results);
                raceResultEntities.forEach(res -> res.setSeasonId(seasonEntity.getId()));
                raceResultRepository.persist(raceResultEntities);
            }
        } catch (Exception ex) {
            LOGGER.error("load seasons failed", ex);
        }
    }

    private File[] getSeasonFiles() {
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(FILTER_EXT);
            }
        };
        File dir = new File(DATA_DIR);
        return dir.listFiles(filter);
    }
}
