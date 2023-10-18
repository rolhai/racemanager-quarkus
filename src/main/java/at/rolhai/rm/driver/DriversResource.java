package at.rolhai.rm.driver;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("drivers")
public class DriversResource {

    @Inject
    DriverService driverService;

    @GET
    public Response getDrivers() {
        Object result = driverService.getDrivers();
        return Response.ok(result).build();
    }
    
}
