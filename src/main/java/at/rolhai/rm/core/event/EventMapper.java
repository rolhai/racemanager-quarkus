package at.rolhai.rm.core.event;

import at.rolhai.rm.app.MapperConfiguration;
import at.rolhai.rm.data.core.EventData;
import at.rolhai.rm.core.event.db.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    EventEntity mapToEntity(EventData data);

    List<EventEntity> mapToEntities(List<EventData> data);

    EventData mapToData(EventEntity entity);

    List<EventData> mapToData(List<EventEntity> entities);
}
