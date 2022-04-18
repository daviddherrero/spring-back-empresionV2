package tfg.backend.empresion.service.interfaces;

import tfg.backend.empresion.domain.Order;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface IOrderService {

    Object getFileByOrderId = null;

    File getEmail(String id);

    UserDTO getUser(String id) throws Exception;

    OrderDTO getOrderById(String id) throws Exception;

    List<OrderDTO> getOrdersByUserId(String id);

    Date getCreationDate(String id) throws Exception;

    String getOrderStatus(String id) throws Exception;

    void addOrder(Order order) throws Exception;

    void updateOrder(String id) throws Exception;

    String getFileByOrderId(String id) throws Exception;
}
