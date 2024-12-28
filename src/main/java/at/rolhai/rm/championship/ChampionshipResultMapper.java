package at.rolhai.rm.championship;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.championship.db.ChampionshipResultEntity;
import at.rolhai.rm.data.championship.ChampionshipResultData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface ChampionshipResultMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "championship", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "driver", ignore = true)
    @Mapping(target = "bestTime", source = "bestTime")
    @Mapping(target = "bestTimeMinutes", ignore = true)
    @Mapping(target = "bestTimeSeconds", ignore = true)
    @Mapping(target = "bestTimeMilliseconds", ignore = true)
    ChampionshipResultEntity mapToEntity(ChampionshipResultData data);
}
