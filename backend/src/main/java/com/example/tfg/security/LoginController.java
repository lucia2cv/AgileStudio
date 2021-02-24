package com.example.tfg.security;

import com.example.tfg.entities.usuario.Users;
import com.example.tfg.entities.usuario.UserComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserComponent userComponent;

   // @GetMapping(path = "/login")
  // @RequestMapping(value= "/", method = RequestMethod.GET)
   @GetMapping("/")
    public ResponseEntity<Users>login(){
        if(!userComponent.isLoggedUser()){
            log.info("usuario no registrado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            Users loggedUsers =userComponent.getLoggedUser();
            log.info("Entra");
            return new ResponseEntity<>(loggedUsers,HttpStatus.OK);
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
