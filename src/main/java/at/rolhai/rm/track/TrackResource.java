package at.rolhai.rm.track;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "tracks")
public interface TrackResource extends PanacheMongoRepositoryResource<TrackRepository, TrackEntity, ObjectId> {
    
    @GET
    @Path("filter")
    default public Response findByFilter(@QueryParam("name") String name) {
        TrackRepository repository = CDI.current().select(TrackRepository.class).get();
        Object result = repository.findByFilter(name);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(result).build();

    }
}
