package com.example.tfg.entities.usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserComponent {
    private Users users;
    public Users getLoggedUser(){
        return users;
    }
    public void setLoggedUser(Users users){
        this.users = users;
    }

    public boolean isLoggedUser(){
        return this.users != null;
    }

}
