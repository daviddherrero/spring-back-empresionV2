package tfg.backend.empresion.service.interfaces;

import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;

import java.io.File;
import java.util.List;

public interface IUserService {

    void updateUser(User user) throws Exception;

    UserDTO getUser(String id) throws Exception;

    String getEmail(String id) throws Exception;

    List<OrderDTO> getOrders(String id) throws Exception;

    void saveUser(User user) throws Exception;
    
}
