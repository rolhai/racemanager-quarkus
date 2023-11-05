package at.rolhai.rm.driver.boundary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import at.rolhai.rm.driver.entity.DriverEntity;

@Mapper
interface DriverMapper {

    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverEntity toDriverEntity(Driver obj);

    Driver toDriver(DriverEntity obj);
    
}
