package at.rolhai.rm.core.team;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.core.TeamData;
import at.rolhai.rm.core.team.db.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    TeamEntity mapToEntity(TeamData data);

    List<TeamEntity> mapToEntities(List<TeamData> data);

    TeamData mapToData(TeamEntity entity);

    List<TeamData> mapToData(List<TeamEntity> entities);
}
