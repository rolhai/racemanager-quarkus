package at.rolhai.rm.result;

import at.rolhai.rm.result.db.RaceResultEntity;
import at.rolhai.rm.result.db.RaceResultRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "races/results")
public interface RaceResultResource extends PanacheRepositoryResource<RaceResultRepository, RaceResultEntity, Long> {
    
}
