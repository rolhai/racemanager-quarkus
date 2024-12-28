package at.rolhai.rm.core.season;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.core.SeasonData;
import at.rolhai.rm.core.season.db.SeasonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface SeasonMapper {

    @Mapping(target = "id", ignore = true)
    SeasonEntity mapToEntity(SeasonData data);

    List<SeasonEntity> mapToEntities(List<SeasonData> data);

    SeasonData mapToData(SeasonEntity entity);

    List<SeasonData> mapToData(List<SeasonEntity> entities);
}
