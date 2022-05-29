package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<Users> findOne(long id){
        return userRepository.findById(id);
    }
    public Users finByID(long id) { return userRepository.findUsersById(id);}
    public Users saveUser(Users users){
        return userRepository.save(users);
    }
    public List<Users> getAllUsersList() {return userRepository.findAll();}}
