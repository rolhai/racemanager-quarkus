package at.rolhai.rm.data;

import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("core/data")
public class DataResource {

    @Inject
    CoreDataManager coreDataManager;

    @PUT
    public Response updateCoreData() {
        coreDataManager.updateCoreData();
        return Response.ok().build();
    }
}
