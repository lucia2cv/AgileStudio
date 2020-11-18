package com.example.tfg.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure( HttpSecurity http) throws Exception {
        //http builder conf for authorize requests
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"api/login");
        http.antMatcher("/api/**");
        http
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
        .and()
        .logout()
        .permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/login").permitAll();
    }
}
