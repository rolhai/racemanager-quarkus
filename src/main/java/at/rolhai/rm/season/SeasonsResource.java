package at.rolhai.rm.season;

import java.util.List;

import at.rolhai.rm.driver.db.DriverRepository;
import at.rolhai.rm.season.db.SeasonEntity;
import at.rolhai.rm.season.db.SeasonRepository;
import at.rolhai.rm.team.db.TeamEntity;
import at.rolhai.rm.team.db.TeamRepository;
import at.rolhai.rm.event.db.EventEntity;
import at.rolhai.rm.event.db.EventRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ResourceProperties(path = "seasons")
public interface SeasonsResource extends PanacheRepositoryResource<SeasonRepository, SeasonEntity, Long> {

    private SeasonRepository getSeasonRepository() {
        return CDI.current().select(SeasonRepository.class).get();
    }

    private EventRepository getEventRepository() {
        return CDI.current().select(EventRepository.class).get();
    }

    private DriverRepository getDriverRepository() {
        return CDI.current().select(DriverRepository.class).get();
    }

    private TeamRepository getTeamRepository() {
        return CDI.current().select(TeamRepository.class).get();
    }
    
    @GET
    @Path("filter")
    default public Response findByYear(@QueryParam("year") int year) {
        SeasonRepository repository = CDI.current().select(SeasonRepository.class).get();
        List<SeasonEntity> seasons = repository.findByYear(year);
        if (seasons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(seasons).build();

    }

    @POST
    @Path("/{seasonId}/events")
    default public Response addEvent(@PathParam("seasonId") Long seasonId, EventEntity event) {
        // validate season
        if (seasonId == null) {
            throw new WebApplicationException("no season id", Response.Status.BAD_REQUEST);
        }
        SeasonRepository seasonRepository = getSeasonRepository();
        SeasonEntity seasonEntity = seasonRepository.findById(seasonId);
        if (seasonEntity == null) {
            throw new WebApplicationException(String.format("season with id %s not found", seasonId), Response.Status.NOT_FOUND);
        }
        
        // validate track
        EventRepository eventRepository = getEventRepository();
        EventEntity eventEntity = eventRepository.findByTrackName(event.trackName);
        if (eventEntity == null) {
            throw new WebApplicationException("track not found", Response.Status.BAD_REQUEST);
        }

        return Response.ok().build();
    }

    @POST
    @Path("{seasonId}/teams")
    default public Response addTeam(@PathParam("seasonId") Long seasonId, TeamEntity seasonTeam) {
        // validate season
        if (seasonId == null) {
            throw new WebApplicationException("no season id", Response.Status.BAD_REQUEST);
        }
        SeasonRepository seasonRepository = getSeasonRepository();
        SeasonEntity seasonEntity = seasonRepository.findById(seasonId);
        if (seasonEntity == null) {
            throw new WebApplicationException(String.format("season with id %s not found", seasonId), Response.Status.NOT_FOUND);
        }
        seasonRepository.persist(seasonEntity);
        return Response.ok().build();
    }
}
