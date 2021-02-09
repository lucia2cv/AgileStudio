package com.example.tfg.security;

import com.example.tfg.entities.usuario.Users;
import com.example.tfg.entities.usuario.UserComponent;
import com.example.tfg.entities.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserComponent userComponent;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String nombre = authentication.getName();
        String password = (String)authentication.getCredentials();

        Users users = userRepository.findByNombre(nombre);

        if ( users == null){
            System.out.println("No autenticado");
            throw new BadCredentialsException("User doesnt exist");
        }
        if (!new BCryptPasswordEncoder().matches(password, users.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }else{
            userComponent.setLoggedUser(users);
            List<GrantedAuthority> roles = new ArrayList<>();
            String role = users.getRol();
            roles.add(new SimpleGrantedAuthority(role));
            return  new UsernamePasswordAuthenticationToken(nombre,password,roles);
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
