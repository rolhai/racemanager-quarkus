package at.rolhai.rm.event.db;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository implements PanacheRepository<EventEntity> {

    public EventEntity findByTrackName(String trackName) {
        return find("trackName = :trackName",
            Parameters
            .with("trackName", trackName))
            .singleResult();
    }
    
}
