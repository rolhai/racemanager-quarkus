package at.rolhai.rm.core.season.db;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeasonRepository implements PanacheRepository<SeasonEntity> {

    public List<SeasonEntity> findByYear(int seasonYear) {
        return find("seasonYear =: seasonYear", Parameters
                .with("seasonYear", seasonYear))
                .list();
    }

    public SeasonEntity findBySimulation(String simulation, int seasonYear) {
        return find("simulation =: simulation and seasonYear =: seasonYear", Parameters
                .with("simulation", simulation)
                .and("seasonYear", seasonYear))
                .singleResult();
    }

}
