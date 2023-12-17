package at.rolhai.rm.season;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeasonRepository implements PanacheMongoRepository<SeasonEntity> {

    public List<SeasonEntity> findByFilter(Integer year) {
        return find("year =: year",
            Parameters.with("year", year))
            .list();
    }
    
}
