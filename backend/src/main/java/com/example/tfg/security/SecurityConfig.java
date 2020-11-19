package com.example.tfg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired UserAuthenticationProvider authenticationProvider;

    protected void configure( HttpSecurity http) throws Exception {
        //Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        //Private pages(all the others)
        //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/home").hasAnyRole("DESARROLLADOR","SCRUM MASTER","PRODUCT OWNER");
        //LoginForm
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");

        //Logut
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        //Disable CSRF
        http.csrf().disable();
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //DB authentication
        auth.authenticationProvider(authenticationProvider);
    }
}
