package at.rolhai.rm.core.country;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.core.country.db.CountryEntity;
import at.rolhai.rm.data.core.CountryData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    CountryEntity mapToEntity(CountryData data);

    List<CountryEntity> mapToEntities(List<CountryData> data);

    CountryData mapToData(CountryEntity entity);

    List<CountryData> mapToData(List<CountryEntity> entities);
}
