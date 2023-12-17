package at.rolhai.rm.track;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrackRepository implements PanacheMongoRepository<TrackEntity> {

    public List<TrackEntity> findByFilter(String name) {
        return find("name = :name",
                Parameters.with("name", name))
                .list();
    }
    
}
