package at.rolhai.rm.event;

import at.rolhai.rm.event.db.EventEntity;
import at.rolhai.rm.event.db.EventRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "events")
public interface EventResource extends PanacheRepositoryResource<EventRepository, EventEntity, Long> {
    
    @GET
    @Path("filter")
    default public Response findByTrackName(@QueryParam("name") String trackName) {
        EventRepository repository = CDI.current().select(EventRepository.class).get();
        Object result = repository.findByTrackName(trackName);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(result).build();

    }
}
