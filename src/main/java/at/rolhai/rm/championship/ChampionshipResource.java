package at.rolhai.rm.championship;

import at.rolhai.rm.championship.db.ChampionshipEntity;
import at.rolhai.rm.championship.db.ChampionshipRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "championships")
public interface ChampionshipResource extends PanacheRepositoryResource<ChampionshipRepository, ChampionshipEntity, Long> {

}
