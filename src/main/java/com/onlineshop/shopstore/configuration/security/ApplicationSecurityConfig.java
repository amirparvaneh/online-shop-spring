package com.onlineshop.shopstore.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/public/**").and()
                .authorizeRequests()
                .mvcMatchers("/orders").authenticated()
//                .mvcMatchers("/dashboard").authenticated()
                .mvcMatchers("/products").permitAll()
                .mvcMatchers("/public/**").permitAll()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/orders")
                .failureUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // change encryption type if needed
    }


}
