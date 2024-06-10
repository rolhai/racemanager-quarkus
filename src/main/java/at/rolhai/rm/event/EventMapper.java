package at.rolhai.rm.event;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.core.EventData;
import at.rolhai.rm.event.db.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seasonId", ignore = true)
    @Mapping(target = "orderNumber", ignore = true)
    EventEntity mapToEntity(EventData data);

    List<EventEntity> mapToEntities(List<EventData> data);

    EventData mapToData(EventEntity entity);

    List<EventData> mapToData(List<EventEntity> entities);
}
