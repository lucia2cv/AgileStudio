package com.example.tfg.registration;

import com.example.tfg.entities.usuario.User;
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
    public User saveUser(@RequestBody User user) throws Exception {

        //check the email doesnt exist
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            User userObj = service.fetchUserByEmail(tempEmail);
            if(userObj !=null ){
                throw new Exception("Email ya registrado");
            }
        }
        service.saveUser(user);
        return user;
        /*User userObj = null;
        userObj = service.saveUser(user);
        return userObj;*/
    }

}
