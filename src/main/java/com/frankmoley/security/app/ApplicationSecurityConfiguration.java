package com.frankmoley.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Below settings allowed anyone to access index page but view guest needed authentication
    	http  // call to http builder
                .csrf().disable()	// to prevent csrf exploit
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/*", "/js/*").permitAll()  // root, indexpage allowed, any static css or javascript pages
                .anyRequest().authenticated() // right now authenticate every request
                .and()
                .httpBasic();
    }
}
