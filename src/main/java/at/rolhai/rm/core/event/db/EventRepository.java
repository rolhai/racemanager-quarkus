package at.rolhai.rm.core.event.db;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository implements PanacheRepository<EventEntity> {

    public EventEntity findByTrackName(String trackName) {
        return find("trackName = :trackName",
                Parameters.with("trackName", trackName))
                .singleResult();
    }

    public EventEntity findByLocation(String location) {
        return find("location = :location",
                Parameters.with("location", location))
                .singleResult();
    }
}
