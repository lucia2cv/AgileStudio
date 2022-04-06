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
import java.util.ArrayList;
import java.util.List;

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
        /*List<String> listCat1 = new ArrayList<>();
        listCat1.add("ciberseguridad");

        List<String> listCat2 = new ArrayList<>();
        listCat2.add("scrum");

        List<String> listCat3 = new ArrayList<>();
        listCat3.add("Vue3");
        listCat3.add("Js");*/

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



        Taller taller1  = new Taller("Cyber" , "ciberseguridad", "https://www.itdigitalsecurity.es/files/202203/ciberseguridad.jpg");
        Taller taller2  = new Taller("Scrum Coffe" , "scrum", "https://insights.dice.com/wp-content/uploads/2018/07/shutterstock_496292356.jpg");
        Taller taller3  = new Taller("Vue3 Masterclass" , "Vue", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748");
        Taller taller4  = new Taller("JS Masterclass" , "JS", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748");
        Taller taller5  = new Taller("Cyber2" , "ciberseguridad", "https://www.itdigitalsecurity.es/files/202203/ciberseguridad.jpg");
        Taller taller6  = new Taller("Scrum Coffe2" , "scrum", "https://insights.dice.com/wp-content/uploads/2018/07/shutterstock_496292356.jpg");
        Taller taller7  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");
        Taller taller8  = new Taller("JS Masterclass" , "JS", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748");
        Taller taller9  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");
        Taller taller10  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");
        Taller taller11  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");
        Taller taller12  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");
        Taller taller13  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png");

        tallerRepository.save(taller1);
        tallerRepository.save(taller2);
        tallerRepository.save(taller3);
        tallerRepository.save(taller4);
        tallerRepository.save(taller5);
        tallerRepository.save(taller6);
        tallerRepository.save(taller7);
        tallerRepository.save(taller8);
        tallerRepository.save(taller9);
        tallerRepository.save(taller10);
        tallerRepository.save(taller11);
        tallerRepository.save(taller12);
        tallerRepository.save(taller13);

        equipo1.getTalleres().add(taller1);
        equipo1.getTalleres().add(taller4);
        equipo2.getTalleres().add(taller1);
        equipo2.getTalleres().add(taller2);
        equipo2.getTalleres().add(taller3);
        equipo2.getTalleres().add(taller4);
        equipo2.getTalleres().add(taller5);
        equipo2.getTalleres().add(taller6);
        equipo2.getTalleres().add(taller7);
        equipo2.getTalleres().add(taller8);
        equipo2.getTalleres().add(taller9);
        equipo2.getTalleres().add(taller10);
        equipo2.getTalleres().add(taller11);
        equipo2.getTalleres().add(taller12);
        equipo2.getTalleres().add(taller13);

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
