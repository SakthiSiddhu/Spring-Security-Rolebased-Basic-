package com.ust.Spring_InMemory_Authentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass")
                .roles("user_role")
                .and()
                .withUser("admin")
                .password("{noop}password")
                .roles("admin_role");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/user").
                hasRole("user_role")
                .antMatchers("/api/admin")
                .hasRole("admin_role")
                .and()
                .httpBasic();

    }


}
