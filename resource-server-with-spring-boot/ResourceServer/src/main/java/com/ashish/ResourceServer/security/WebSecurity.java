package com.ashish.ResourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/status/check")
//                .hasAuthority("SCOPE_profile")
                .hasRole("developer") //will check for the specific role
//                .hasAnyRole("role_one", "role_two") // will check for any role and we can provide as many roles
        .anyRequest().authenticated().and().oauth2ResourceServer().jwt();
    }
}
