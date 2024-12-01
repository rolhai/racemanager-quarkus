package at.rolhai.rm.core.driver;

import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.driver.db.DriverRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "drivers")
public interface DriverResource extends PanacheRepositoryResource<DriverRepository, DriverEntity, Long> {
   
    @GET
    @Path("filter")
    default public Response findByFilter(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname) {
        DriverRepository repository = CDI.current().select(DriverRepository.class).get();
        Object result = repository.findByDriverName(firstname, lastname);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(result).build();

    }
}
