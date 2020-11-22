package com.example.tfg.security;

import com.example.tfg.entities.usuario.User;
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
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = (String)auth.getCredentials();

        User user = (User) userRepository.findByNombre(auth.getName());

        if ( user == null){
            System.out.println("No autenticado");
            throw new BadCredentialsException("User doesnt exist");
        }
        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }else{
            userComponent.setLoggedUser(user);
            List<GrantedAuthority> roles = new ArrayList<>();
            String role = user.getRol();
            roles.add(new SimpleGrantedAuthority(role));
            return  new UsernamePasswordAuthenticationToken(username,password,roles);
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
