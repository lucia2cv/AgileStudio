package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/home")
public class UserController {   //todos los metodos de busqueda

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    /*Add user*/
    @PostMapping(value = "/users/")
    @ResponseStatus(HttpStatus.CREATED)
    public Users newUser(@RequestBody Users users){
        userRepository.save(users);
        return users;
    }

    @GetMapping("/")
    public ResponseEntity<Users> getUserById(@PathVariable long id){
        Users usuario = userService.findOne(id).get();
        if (usuario != null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/editarPerfil/{id}")
    public Users updateUser(@PathVariable long id, @RequestBody Users updateUser){
        System.out.println("updateUser");
        userService.findOne(id).get();
        updateUser.setId(id);
        userService.saveUser(updateUser);
        return updateUser;
    }

}
