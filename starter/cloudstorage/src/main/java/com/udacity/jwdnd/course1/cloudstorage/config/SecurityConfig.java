package com.udacity.jwdnd.course1.cloudstorage.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        try{
            http.authorizeRequests().antMatchers("/signup", "/css/**", "/js/**")
                    .permitAll().anyRequest().authenticated();
            http.formLogin()
                    .loginPage("/login").permitAll();
            http.formLogin()
                    .defaultSuccessUrl("/home", true);
            http.logout()
                    .logoutUrl("/logout").permitAll();
            http.logout()
                    .logoutSuccessUrl("/login").permitAll();
        } catch(Exception e) {
            logger.error("Exception thrown at security layer: " + e);
        }

    }

}
