package at.rolhai.rm.result;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RaceResultRepository implements PanacheMongoRepository<RaceResultEntity> {
    
}
