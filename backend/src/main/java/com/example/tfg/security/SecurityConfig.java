package com.example.tfg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired UserAuthenticationProvider authenticationProvider;

    protected void configure( HttpSecurity http) throws Exception {
        //Public pages
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/").permitAll();
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/login").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/loginerror").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/logout").permitAll();

        //Private pages(all the others)
        //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/home").hasAnyRole("desarrollador","scrum master","product owner");
        /*LoginForm
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");

        //Logut
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");*/

        //Disable CSRF
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        http.httpBasic();

    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //DB authentication
        auth.authenticationProvider(authenticationProvider);
    }
}
