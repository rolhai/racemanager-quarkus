package at.rolhai.rm.core.team.db;

import at.rolhai.rm.core.event.db.EventEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<TeamEntity> {

    public TeamEntity findByName(String name) {
        return find("name = :name",
                Parameters.with("name", name))
                .singleResult();
    }
}
