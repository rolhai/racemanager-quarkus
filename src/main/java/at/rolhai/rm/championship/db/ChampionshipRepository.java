package at.rolhai.rm.championship.db;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChampionshipRepository implements PanacheRepository<ChampionshipEntity> {
}