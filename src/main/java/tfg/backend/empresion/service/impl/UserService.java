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
import tfg.backend.empresion.service.interfaces.IUserService;
import tfg.backend.empresion.service.mongosequences.UserNextSequenceService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

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
    public void updateUser(User newUser) throws Exception {
        Optional<User> user = userRepository.findById(newUser.getId());
        if(user.isPresent()){
            userRepository.save(newUser);
        }else{
            logger.error("EL pedido no esta correctamente definido");
            throw new Exception("Order incorrectly defined");
        }
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return userConverter.entityToDto(user.get());
        }else{
            logger.error("EL usuario buscado no existe");
            throw new Exception("User not found");
        }
    }

    @Override
    public String getEmail(String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get().getEmail();
        }else{
            logger.error("EL usuario buscado no existe");
            throw new Exception("User not found");
        }
    }


        @Override
        public List<OrderDTO> getOrders(String id) throws Exception {
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent()){
                List<Order> orders = orderRepository.findByUserId(id);
                List<OrderDTO> dtos = new ArrayList<>();
                for (Order order : orders) {
                    dtos.add(new OrderDTO(user.get().getName(), order.getStatus(), order.getCreated_at(), order.getCompleted_at()));
                }
                return dtos;
            }else{
                logger.error("EL usuario buscado no existe");
                throw new Exception("User not found");
            }
        }

    @Override
    public void saveUser(User user) throws Exception {
        if(user != null){
            user.setId(String.valueOf(sequenceService.getNextUserId(User.SEQUENCE_NAME)));
            userRepository.save(user);
        }else{
            logger.error("EL pedido no esta correctamente definido");
            throw new Exception("Order incorrectly defined");
        }
    }

}
