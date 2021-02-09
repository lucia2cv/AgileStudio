package com.example.tfg.registration;

import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    //Metodo al que se llama al submit form
    @Autowired
    private RegistrationService service;

    //@CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/")
    @ResponseStatus (HttpStatus.CREATED)
    public Users saveUser(@RequestBody Users users) throws Exception {

        //check the email doesnt exist
        String tempEmail = users.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            Users usersObj = service.fetchUserByEmail(tempEmail);
            if(usersObj !=null ){
                throw new Exception("Email ya registrado");
            }
        }
        service.saveUser(users);
        return users;
        /*User userObj = null;
        userObj = service.saveUser(user);
        return userObj;*/
    }

}
