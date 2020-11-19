package com.example.tfg;

import com.example.tfg.entities.usuario.User;
import com.example.tfg.entities.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseLoader {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDataBase(){
        userRepository.save(
                new User("user","user","user@email.com","desarrollador",01));

       /* userRepository.save(
                new User("sm","sm","sm@email.com","scrum master",02));
        userRepository.save(
                new User("po","po","po@email.com","product owner",03));*/
    }
}
