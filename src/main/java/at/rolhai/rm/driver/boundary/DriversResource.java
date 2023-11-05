package at.rolhai.rm.driver.boundary;

import java.util.List;

import at.rolhai.rm.driver.control.DriverRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("drivers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DriversResource {

    @Inject
    DriverRepository driverRepository;

    @GET
    public Response getDrivers() {
        List<Driver> result = driverRepository.listAll()
            .stream()
            .map(d -> DriverMapper.INSTANCE.toDriver(d))
            .toList();
        return Response.ok(result).build();
    }
    
}
