package com.spring.testing.init.springconcepttesting;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // only the endpoint with this path "/api/testapi/v1/testing" is not authenticated.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(request -> {

                    if (request.getRequestURI().contains("/api/testapi/v1/testing")) {
                        return false;
                    }
                    return true;
                }).authenticated()
                .and()
                .httpBasic();
    }
}
