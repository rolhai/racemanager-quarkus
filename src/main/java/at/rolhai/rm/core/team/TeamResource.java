package at.rolhai.rm.core.team;

import at.rolhai.rm.core.team.db.TeamEntity;
import at.rolhai.rm.core.team.db.TeamRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "teams")
public interface TeamResource extends PanacheRepositoryResource<TeamRepository, TeamEntity, Long> {
    
}
