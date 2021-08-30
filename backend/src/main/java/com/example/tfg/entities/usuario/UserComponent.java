package com.example.tfg.entities.usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserComponent {
    private Users user;
    public Users getLoggedUser(){
        return user;
    }
    public void setLoggedUser(Users users){
        this.user = users;
    }

    public boolean isLoggedUser(){
        return this.user != null;
    }

}
