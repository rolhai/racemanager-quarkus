package at.rolhai.rm.track.control;

import at.rolhai.rm.track.entity.TrackEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrackRepository implements PanacheRepository<TrackEntity> {
    
}
