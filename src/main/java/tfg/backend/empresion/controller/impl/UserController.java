package tfg.backend.empresion.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tfg.backend.empresion.domain.User;
import tfg.backend.empresion.dto.OrderDTO;
import tfg.backend.empresion.dto.UserDTO;
import tfg.backend.empresion.service.interfaces.IUserService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public void saveUser(User user) throws Exception {
        service.saveUser(user);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUser(User user) throws Exception {
        service.updateUser(user);
    }

    @GetMapping(value = "/getUser/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDTO getUser(@PathVariable(value = "id") String id) throws Exception {
        return service.getUser(id);
    }

    @GetMapping("/getEmail/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String getEmail(@PathVariable("id") String id) throws Exception {
        return service.getEmail(id);
    }

    @GetMapping("/getOrders/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrderDTO> getOrders(@PathVariable("id") String id) throws Exception {
        return service.getOrders(id);
    }
  
}
