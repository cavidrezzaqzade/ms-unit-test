package az.ingress.msunittesting.service;

import az.ingress.msunittesting.dao.entity.User;
import az.ingress.msunittesting.dao.repository.UserRepository;
import az.ingress.msunittesting.mapper.UserMapper;
import az.ingress.msunittesting.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    public UserDto getById(Long id) {
        User user = fetchUserIfExist(id);
        return mapper.entityToDto(user);
    }

    public UserDto add(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(repository.save(user));
    }

    public void delete(Long id) {
        User user = fetchUserIfExist(id);
        repository.delete(user);
    }

    public UserDto update(UserDto dto, Long id) {
        User user = fetchUserIfExist(id);
        User userNew = mapper.updateUser(user, dto);
        return mapper.entityToDto(repository.save(userNew));
    }

    private User fetchUserIfExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("user was not found"));
    }

}
