package tfg.backend.empresion.converter.impl;

import org.springframework.stereotype.Component;
import tfg.backend.empresion.converter.EntityToDtoConverter;
import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.UserDTO;

@Component
public class UserEntityConverter implements EntityToDtoConverter<User, UserDTO> {

    @Override
    public UserDTO entityToDto(User entity) {
        return new UserDTO(entity.getName(), entity.getUsername(), entity.getRole());
    }

    @Override
    public User dtoToEntity(UserDTO dto) {
        return null;
    }
}
