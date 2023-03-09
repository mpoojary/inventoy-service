package com.demo.inventoryservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests)->requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/app/**").authenticated()
                        .requestMatchers(HttpMethod.GET,"/app/item").hasRole("USER").anyRequest().authenticated())
                .formLogin().permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("luff")
                .password("luff")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
