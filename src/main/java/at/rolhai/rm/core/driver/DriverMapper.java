package at.rolhai.rm.core.driver;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.core.DriverData;
import at.rolhai.rm.core.driver.db.DriverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface DriverMapper {

    @Mapping(target = "id", ignore = true)
    DriverEntity mapToEntity(DriverData data);

    List<DriverEntity> mapToEntities(List<DriverData> data);

    DriverData mapToData(DriverEntity entity);

    List<DriverData> mapToData(List<DriverEntity> entities);
}
