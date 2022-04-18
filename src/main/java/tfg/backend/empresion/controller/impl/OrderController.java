package tfg.backend.empresion.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tfg.backend.empresion.controller.interfaces.IOrderController;
import tfg.backend.empresion.domain.Order;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;
import tfg.backend.empresion.service.interfaces.IOrderService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController implements IOrderController{
    
    @Autowired
    private IOrderService service;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public void addOrder(Order order) throws Exception {
        service.addOrder(order);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateOrder(@PathVariable String id) throws Exception {
        service.updateOrder(id);
    }

    @GetMapping("/getOrders/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrderDTO> getOrdersByUserId(@PathVariable String id){
        return service.getOrdersByUserId(id);
    }

    @GetMapping("/getOrder/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrderDTO getOrderById(@PathVariable String id) throws Exception {
        return service.getOrderById(id);
    }

    @GetMapping("/getCreationDate/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Date getCreationDate(@PathVariable String id) throws Exception {
        return service.getCreationDate(id);
    }

    @GetMapping("/getUser/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDTO getUser(@PathVariable String id) throws Exception {
        return service.getUser(id);
    }

    @GetMapping("/getOrderStatus/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String getOrderStatus(@PathVariable String id) throws Exception {
        return service.getOrderStatus(id);
    }

    @GetMapping("/getFileByOrderId/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String getFileByOrderId(@PathVariable String id) throws Exception {
        return service.getFileByOrderId(id);
    }

}
