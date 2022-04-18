package tfg.backend.empresion.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.backend.empresion.converter.impl.OrderEntityConverter;
import tfg.backend.empresion.converter.impl.UserEntityConverter;
import tfg.backend.empresion.domain.Order;
import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;
import tfg.backend.empresion.repository.OrderRepository;
import tfg.backend.empresion.repository.UserRepository;
import tfg.backend.empresion.service.interfaces.IOrderService;
import tfg.backend.empresion.service.mongosequences.UserNextSequenceService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService implements IOrderService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityConverter orderConverter;

    @Autowired
    private UserEntityConverter userConverter;

    @Autowired
    private UserNextSequenceService sequenceService;

    private static Logger logger = LogManager.getLogger(OrderService.class);

    @Override
    public File getEmail(String id) {
        return null;
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            Optional<User> user = userRepository.findById(order.get().getUser_id());
            return userConverter.entityToDto(user.get());
        }else{
            logger.error("EL usuario buscado no existe");
            throw new Exception("User not found");
        }
    }

    @Override
    public OrderDTO getOrderById(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return orderConverter.entityToDto(order.get());
        }else{
            logger.error("EL pedido buscado no existe");
            throw new Exception("Order not found");
        }
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(String id) {
        List<Order> orders = orderRepository.findByUserId(id);
        List<OrderDTO> dtos = new ArrayList<>();
        for (Order order : orders) {
            Optional<User> user = userRepository.findById(order.getUser_id());
            dtos.add(new OrderDTO(user.get().getName(), order.getStatus(), order.getCreated_at(), order.getCompleted_at()));
        }
        return dtos;
    }

    @Override
    public Date getCreationDate(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get().getCreated_at();
        }else{
            logger.error("EL pedido buscado no existe");
            throw new Exception("Order not found");
        }
    }

    @Override
    public String getOrderStatus(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get().getStatus();
        }else{
            logger.error("EL pedido buscado no existe");
            throw new Exception("Order not found");
        }
    }

    @Override
    public void addOrder(Order order) throws Exception {
        if(order != null){
            order.setCreated_at(new Date());
            order.setId(String.valueOf(sequenceService.getNextUserId(Order.SEQUENCE_NAME)));
            orderRepository.save(order);
        }else{
            logger.error("EL pedido no esta correctamente definido");
            throw new Exception("Order incorrectly defined");
        }

    }

    @Override
    public void updateOrder(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            orderRepository.save(order.get());
        }else{
            logger.error("EL pedido no esta correctamente definido");
            throw new Exception("Order incorrectly defined");
        }
    }

    @Override
    public String getFileByOrderId(String id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get().getFile();
        }else{
            logger.error("EL pedido buscado no existe");
            throw new Exception("Order not found");
        }
    }
}
