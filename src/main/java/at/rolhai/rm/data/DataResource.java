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
    @Path("export")
    public Response updateCoreData() {
        coreDataManager.exportCoreData();
        return Response.ok().build();
    }
}
