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



        Users user1 = new Users("user1",password,"user@email.com","desarrollador");
        userRepository.save(user1);

        Users user2 = new Users("user2",password,"user@email.com","desarrollador");
        userRepository.save(user2);

        Users user3 = new Users("user3",password,"user@email.com","desarrollador");
        userRepository.save(user3);

        Users user4 = new Users("user4",password,"user@email.com","scrum master");
        userRepository.save(user4);

        Users user5 = new Users("user5",password,"user@email.com","scrum master");
        userRepository.save(user5);

        equipo1.getMiembros().add(user1);
        equipo1.getMiembros().add(user4);
        equipo1.getMiembros().add(user3);
        equipo1.getMiembros().add(user5);

        equipo2.getMiembros().add(user2);
        equipo2.getMiembros().add(user3);
        equipo2.getMiembros().add(user4);



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
