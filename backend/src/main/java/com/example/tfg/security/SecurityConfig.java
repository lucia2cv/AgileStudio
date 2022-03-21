package com.example.tfg.security;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired UserAuthenticationProvider authenticationProvider;
    /*@Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure( HttpSecurity http) throws Exception {
       /* http
                .addFilterBefore(corsFilter(), SessionManagementFilter.class);*/
        http.cors().configurationSource(request ->{
            var cors = new CorsConfiguration();
            cors.addAllowedOrigin("http://localhost:4200");
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        });
       /* http
                .addFilterBefore(corsFilter(), SessionManagementFilter.class);*/
        //Public pages
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/login").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/home").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/equipos").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/talleres").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/home/editarPerfil/{id}").permitAll();
       // http.authorizeRequests().antMatchers(HttpMethod.GET,"/home/{id}").hasAnyRole("desarrollador");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/loginerror").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/logout").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.POST,"/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/equipos").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/talleres").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/editarPerfil/{id}").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/home/editarPerfil/{id}").permitAll();

        //Private pages(all the others)
        //http.authorizeRequests().anyRequest().authenticated();
       // http.authorizeRequests().antMatchers(HttpMethod.GET,"/home").hasRole("desarrollador");

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
/*@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.addAllowedHeader("*");
        config.addExposedHeader("Authorization");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter();
    }*/
}
