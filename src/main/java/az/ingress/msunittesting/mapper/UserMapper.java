package az.ingress.msunittesting.mapper;

import az.ingress.msunittesting.dao.entity.User;
import az.ingress.msunittesting.model.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

/**
 * @author caci
 */

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract User dtoToEntity(UserDto dto);
    public abstract UserDto entityToDto(User entity);

    public abstract List<User> dtosToEntities(List<UserDto> dtos);
    public abstract List<UserDto> entitiesToDtos(List<User> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract User updateUser(@MappingTarget User entity, UserDto dto);

}
