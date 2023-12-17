package at.rolhai.rm.team;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "teams")
public interface TeamResource extends PanacheMongoRepositoryResource<TeamRepository, TeamEntity, ObjectId> {
    
}
