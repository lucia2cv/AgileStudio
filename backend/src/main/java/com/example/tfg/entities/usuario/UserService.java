package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    public List<Users> findAll(){
        return userRepository.findAll();
    }

   /* @Override
    public User registerNewUserAccount(String nombre, String password, String correo ){

    }*/
}
