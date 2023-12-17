package at.rolhai.rm.team;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheMongoRepository<TeamEntity> {
    
}
