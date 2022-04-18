package tfg.backend.empresion.controller.interfaces;

import tfg.backend.empresion.domain.Order;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;

import java.util.Date;
import java.util.List;

public interface IOrderController {

    List<OrderDTO> getOrdersByUserId(String id);

    OrderDTO getOrderById(String id) throws Exception;
    
    void addOrder(Order order) throws Exception;

    void updateOrder(String id) throws Exception;

    Date getCreationDate(String id) throws Exception;

    UserDTO getUser(String id) throws Exception;

    String getOrderStatus(String id) throws Exception;

    String getFileByOrderId(String id) throws Exception;
}
