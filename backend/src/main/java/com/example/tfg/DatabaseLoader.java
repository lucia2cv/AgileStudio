package com.example.tfg;

import com.example.tfg.entities.equipo.Equipo;
import com.example.tfg.entities.equipo.EquipoRepository;
import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.taller.TallerRepository;
import com.example.tfg.entities.usuario.Users;
import com.example.tfg.entities.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseLoader {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TallerRepository tallerRepository;

    @PostConstruct
    private void initDataBase(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("user");

        Equipo equipo1 = new Equipo("equipo1");
        equipoRepository.save(equipo1);

        Equipo equipo2 = new Equipo("equipo2");
        equipoRepository.save(equipo2);


        Users users1 = new Users("user",password,"user@email.com","desarrollador");
        users1.setEquipo(equipo1);


        Users users2 = new Users("user2",password,"user@email.com","desarrollador");
        users2.setEquipo(equipo1);

        Users users3 = new Users("user3",password,"user@email.com","desarrollador");
        users3.setEquipo(equipo2);

        userRepository.save(users1);
        userRepository.save(users2);
        userRepository.save(users3);

        Taller taller1  = new Taller("taller1" , "prueba");
        tallerRepository.save(taller1);

        Taller taller2  = new Taller("taller2" , "scrum");
        tallerRepository.save(taller2);

        equipo1.getTalleres().add(taller1);
        equipo2.getTalleres().add(taller1);
        equipo2.getTalleres().add(taller2);
        equipoRepository.save(equipo1);
        equipoRepository.save(equipo2);



       /* userRepository.save(
                new User("user",password,"user@email.com","desarrollador","equipo"));

        equipoRepository.save(
                new Equipo("equipo1"));*/
       /* userRepository.save(
                new User("sm","sm","sm@email.com","scrum master",02));
        userRepository.save(
                new User("po","po","po@email.com","product owner",03));*/
    }
}
