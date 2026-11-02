package com.jsp.Security_Example.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(  csrf -> csrf.disable())
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests
                        (auth->auth.requestMatchers("/users/signup","/users/signin")
                .permitAll().anyRequest().authenticated());
//                .httpBasic(Customizer.withDefaults());
                
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return new ProviderManager();
    }


//    @Bean
//    public UserDetailsService inMemoryUserDetailsManager() {
//
//        UserDetails user1 = User.withUsername("kamal").password(passwordEncoder.encode("password")).roles("ADMIN").build();
//        UserDetails user2 = User.withUsername("suman").password(passwordEncoder.encode("password")).roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

}
