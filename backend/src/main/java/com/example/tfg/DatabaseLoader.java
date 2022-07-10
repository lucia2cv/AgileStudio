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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("user");

        Equipo equipo1 = new Equipo("equipo1", "https://api.freelogodesign.org/assets/thumb/logo/15046535_400.png?t=637674886270000000");
        equipoRepository.save(equipo1);

        Equipo equipo2 = new Equipo("equipo2", "https://cdn1.vectorstock.com/i/1000x1000/79/15/ss-logos-and-symbols-template-icons-app-vector-20097915.jpg");
        equipoRepository.save(equipo2);

        Equipo equipo3 = new Equipo("URJC", "https://economia.uniroma2.it/public/erasmus/images/rey_juan_carlos_mostoles.jpg");
        equipoRepository.save(equipo3);

        Equipo equipo4 = new Equipo("ETSII", "https://pbs.twimg.com/profile_images/378800000798423814/14d42d3051dd63ae5f6c46c3abd44ad3_400x400.jpeg");
        equipoRepository.save(equipo4);

        Users user1 = new Users("user1",password,"user1@email.com","desarrollador", "https://i.pinimg.com/originals/fc/8a/ee/fc8aee57ed2b300efa3f46ad88f46b0f.jpg");
        userRepository.save(user1);

        Users user2 = new Users("user2",password,"user2@email.com","desarrollador", "https://i.pinimg.com/originals/0a/bb/73/0abb730b167f1dfa3401b533458e75c2.jpg");
        userRepository.save(user2);

        Users user3 = new Users("user3",password,"user3@email.com","desarrollador", "https://i.redd.it/0t49x9lwa8c51.jpg");
        userRepository.save(user3);

        Users user4 = new Users("user4",password,"user4@email.com","scrum master", "https://pbs.twimg.com/media/EUtPVfXX0AAYMd3.jpg");
        userRepository.save(user4);

        Users user5 = new Users("user5",password,"user5@email.com","scrum master", "https://thicc.mywaifulist.moe/waifus/36498/aa551bf7420d0637353746af238de1b8a9c432a887bebd9a283f446c066a84fa_thumb.jpeg");
        userRepository.save(user5);

        Users lucia = new Users("lucia",password,"lucia@gmail.com","desarrollador", "https://media-exp2.licdn.com/dms/image/C5603AQGtxMPd1TVlDA/profile-displayphoto-shrink_200_200/0/1583099986262?e=2147483647&v=beta&t=-4ED8a1WskF_omzzholGyr9YgxBTDvUSUEAR677UA4M");
        userRepository.save(lucia);

        Users gema = new Users("gema",password,"gema@gmail.com","scrum master", "https://media-exp1.licdn.com/dms/image/C5603AQFPXvL5FK86IA/profile-displayphoto-shrink_200_200/0/1546085887582?e=1659571200&v=beta&t=AGuoVww7ql2DYc_BMCfjMntCFl19TQSYcN5A18IO1fA");
        userRepository.save(gema);

        equipo1.getMiembros().add(user1);
        equipo1.getMiembros().add(user4);
        equipo1.getMiembros().add(user3);
        equipo1.getMiembros().add(user5);

        equipo2.getMiembros().add(user2);
        equipo2.getMiembros().add(user3);
        equipo2.getMiembros().add(user4);

        equipo3.getMiembros().add(lucia);
        equipo3.getMiembros().add(gema);
        equipo4.getMiembros().add(lucia);
        equipo4.getMiembros().add(gema);

        Taller taller1  = new Taller("Cyber" , "ciberseguridad", "https://www.itdigitalsecurity.es/files/202203/ciberseguridad.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller2  = new Taller("Scrum Coffee" , "scrum", "https://insights.dice.com/wp-content/uploads/2018/07/shutterstock_496292356.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller3  = new Taller("Vue3 Masterclass" , "Vue", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller4  = new Taller("JS Masterclass" , "JS", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller5  = new Taller("Cyber2" , "ciberseguridad", "https://www.itdigitalsecurity.es/files/202203/ciberseguridad.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller6  = new Taller("Scrum Coffee2" , "scrum", "https://insights.dice.com/wp-content/uploads/2018/07/shutterstock_496292356.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller7  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller8  = new Taller("JS Masterclass" , "JS", "https://d2sofvawe08yqg.cloudfront.net/vuejs3/s_hero?1620610748",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller9  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller10  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller11  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller12  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");
        Taller taller13  = new Taller("Vue3 Master" , "Vue", "https://styde.net/wp-content/uploads/2017/02/vue-img-destacada-x2.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam", "https://meet.google.com/");

        Taller taller14  = new Taller("Introducción a Salesforce" , "Salesforce", "https://wp.salesforce.com/blog/wp-content/uploads/sites/2/2015/09/salesforce-ecosystem-explained.png",
                "En este curso aprenderás todo lo necesario para iniciarte en el mundo de Salesforce y hacer de esto tu trabajo.", "meet.google.com/rzc-ijgj-ixo");

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
        tallerRepository.save(taller14);

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

        equipo3.getTalleres().add(taller1);
        equipo3.getTalleres().add(taller14);
        equipo4.getTalleres().add(taller2);
        equipoRepository.save(equipo1);
        equipoRepository.save(equipo2);
        equipoRepository.save(equipo3);
        equipoRepository.save(equipo4);

    }
}
