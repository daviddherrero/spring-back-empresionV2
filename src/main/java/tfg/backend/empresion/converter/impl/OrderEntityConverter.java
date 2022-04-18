package tfg.backend.empresion.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tfg.backend.empresion.converter.EntityToDtoConverter;
import tfg.backend.empresion.domain.Order;
import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.repository.UserRepository;

import java.util.Optional;

@Component
public class OrderEntityConverter implements EntityToDtoConverter<Order, OrderDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO entityToDto(Order entity) {
        Optional<User> user = userRepository.findById(entity.getUser_id());
        return new OrderDTO(user.get().getName(), entity.getStatus(), entity.getCompleted_at(), entity.getCreated_at());
    }

    @Override
    public Order dtoToEntity(OrderDTO dto) {
        return null;
    }
}
