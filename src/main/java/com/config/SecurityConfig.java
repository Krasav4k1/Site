package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/settings/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/music/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/video/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/message/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/friends/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/albom/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/AdminPage/**").hasRole("ADMIN")
            .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/MainPage")
                .failureUrl("/ErrorEntrance")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
            .and()
                .rememberMe();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

}