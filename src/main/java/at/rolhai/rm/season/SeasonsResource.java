package at.rolhai.rm.season;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "seasons")
public interface SeasonsResource extends PanacheMongoRepositoryResource<SeasonRepository, SeasonEntity, ObjectId> {  
    
    @GET
    @Path("filter")
    default public Response findByFilter(@QueryParam("year") Integer year) {
        SeasonRepository repository = CDI.current().select(SeasonRepository.class).get();
        Object result = repository.findByFilter(year);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(result).build();

    }
}
