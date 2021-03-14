package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Optional<Users> findOne(long id){
        return userRepository.findById(id);
    }

}
