package at.rolhai.rm.season;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.season.SeasonData;
import at.rolhai.rm.season.db.SeasonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface SeasonMapper {

    @Mapping(target = "id", ignore = true)
    SeasonEntity mapToEntity(SeasonData data);

    List<SeasonEntity> mapToEntities(List<SeasonData> data);

    @Mapping(target = "results", ignore = true)
    SeasonData mapToData(SeasonEntity entity);

    List<SeasonData> mapToData(List<SeasonEntity> entities);
}
