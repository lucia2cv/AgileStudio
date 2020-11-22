package com.example.tfg.security;

import com.example.tfg.entities.usuario.User;
import com.example.tfg.entities.usuario.UserComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserComponent userComponent;
    @RequestMapping(value = "/login")
    public ResponseEntity<User>login(){
        if (!userComponent.isLoggedUser()){
            log.info("usuario no registrado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            User loggedUser = userComponent.getLoggedUser();
            log.info("logged");
            return new ResponseEntity<>(loggedUser,HttpStatus.OK);
        }
    }
    @RequestMapping("/api/logout")
    public ResponseEntity<Boolean>logout(HttpSession session){
        if(!userComponent.isLoggedUser()){
            log.info("Not logged user");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            session.invalidate();
            log.info("Closed Session");
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }
}
