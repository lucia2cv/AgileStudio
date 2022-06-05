package com.example.tfg.entities.usuario;

import com.example.tfg.entities.equipo.Equipo;
import com.example.tfg.entities.equipo.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/home")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private EquipoService equipoService;
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
    @GetMapping("/registro")
    public List<Equipo> getAllTeams(){ return equipoService.getAllTeams();}

    @PostMapping("/registro")
    public ResponseEntity<Long> saveUser(@RequestBody RegisterForm registerForm){

        try {
            if (registerForm.getTeams().length == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userService.saveNewUser(registerForm);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
