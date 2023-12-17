package at.rolhai.rm.company;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "companies")
public interface CompanyResource extends PanacheMongoRepositoryResource<CompanyRepository, CompanyEntity, ObjectId> {
    
}
