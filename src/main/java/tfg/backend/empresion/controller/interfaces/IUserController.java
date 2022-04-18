package tfg.backend.empresion.controller.interfaces;

import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.OrderDTO;

import java.io.File;
import java.util.List;

public interface IUserController {
    
    void saveUser(User user);

    void updateUser(User user);

    User getUser(long id);

    String getEmail(long id);

    List<OrderDTO> getOrders(long id);
}
