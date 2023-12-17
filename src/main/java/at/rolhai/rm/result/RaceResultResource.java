package at.rolhai.rm.result;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "races/results")
public interface RaceResultResource extends PanacheMongoRepositoryResource<RaceResultRepository, RaceResultEntity, ObjectId> {
    
}
