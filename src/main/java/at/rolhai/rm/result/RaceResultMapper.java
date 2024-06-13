package at.rolhai.rm.result;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.season.RaceResultData;
import at.rolhai.rm.result.db.RaceResultEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface RaceResultMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    RaceResultEntity mapToEntity(RaceResultData data);

    List<RaceResultEntity> mapToEntities(List<RaceResultData> data);

    RaceResultData mapToData(RaceResultEntity entity);

    List<RaceResultData> mapToData(List<RaceResultEntity> entities);
}
