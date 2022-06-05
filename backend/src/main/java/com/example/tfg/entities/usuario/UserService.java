package com.example.tfg.entities.usuario;

import com.example.tfg.entities.equipo.Equipo;
import com.example.tfg.entities.equipo.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EquipoRepository equipoRepository;

    public Optional<Users> findOne(long id){
        return userRepository.findById(id);
    }
    public Users finByID(long id) { return userRepository.findUsersById(id);}
    public Users saveUser(Users users){
        return userRepository.save(users);
    }
    public List<Users> getAllUsersList() {return userRepository.findAll();}
    public Users saveNewUser(RegisterForm registerForm) throws IllegalArgumentException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Users newUser;
        newUser = new Users();
        long [] registerFormTeamsList = registerForm.getTeams();
        List<Equipo> equipos = new ArrayList<>();
        newUser.setNombre(registerForm.getNombre());
        newUser.setEmail(registerForm.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        newUser.setImg(registerForm.getImg());
        newUser.setRol(registerForm.getRol());
        for (long id: registerFormTeamsList) {
            Equipo equipo = equipoRepository.findById(id);
            equipos.add(equipo);
        }
        newUser.setEquipos(equipos);
        userRepository.save(newUser);
        for (long id: registerFormTeamsList) {
            Equipo equipo = equipoRepository.findById(id);
            equipo.getMiembros().add(newUser);
            equipoRepository.save(equipo);
        }
        return userRepository.save(newUser);
    }
}
