package com.imcjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableGlobalAuthentication
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/admin").hasRole("admin")
                        .requestMatchers("/customer/login").permitAll()
                        .requestMatchers("/customer/signup").permitAll()
                        .requestMatchers("/api/customer").hasAnyRole("admin", "customer")
                        .requestMatchers("/api/service-provider").hasAnyRole("admin", "sp")


                        .anyRequest()
                        .authenticated()


                )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails  customerUser = User.withUsername("aamir")
                .password(passwordEncoder().encode("aamir")).
                roles("customer")
                .build();

        UserDetails  spUser = User.withUsername("sp")
                .password(passwordEncoder().encode("sp"))
                .roles("sp")
                .build();
        UserDetails  adminUser = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(customerUser,spUser,adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
