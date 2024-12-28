package at.rolhai.rm.championship;

import at.rolhai.rm.championship.db.ChampionshipResultEntity;
import at.rolhai.rm.championship.db.ChampionshipResultRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "championships/results")
public interface ChampionshipResultResource extends PanacheRepositoryResource<ChampionshipResultRepository, ChampionshipResultEntity, Long> {
    
}
