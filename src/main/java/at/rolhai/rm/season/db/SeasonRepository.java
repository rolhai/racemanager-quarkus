package at.rolhai.rm.season.db;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeasonRepository implements PanacheRepository<SeasonEntity> {

    public List<SeasonEntity> findByYear(int seasonYear) {
        return find("seasonYear =: seasonYear",
            Parameters.with("seasonYear", seasonYear))
            .list();
    }
    
}
