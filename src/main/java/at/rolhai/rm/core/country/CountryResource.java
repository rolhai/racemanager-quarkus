package at.rolhai.rm.core.country;

import at.rolhai.rm.core.country.db.CountryEntity;
import at.rolhai.rm.core.country.db.CountryRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "countries")
public interface CountryResource extends PanacheRepositoryResource<CountryRepository, CountryEntity, Long> {

    @GET
    @Path("filter")
    default public Response findByFilter(@QueryParam("iocCode") String iocCode) {
        CountryRepository repository = CDI.current().select(CountryRepository.class).get();
        Object result = repository.findByIcoCode(iocCode);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(result).build();

    }
}
