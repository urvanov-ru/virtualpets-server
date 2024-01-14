package ru.urvanov.virtualpets.server.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import jakarta.servlet.Filter;
import ru.urvanov.virtualpets.server.auth.CustomAuthenticationEntryPoint;
import ru.urvanov.virtualpets.server.auth.CustomAuthenticationProcessingFilter;
import ru.urvanov.virtualpets.server.auth.DatabaseAuthenticationProvider;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain0(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/site/*").permitAll())
                .build();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain1(HttpSecurity http, AuthenticationManager authenticationManager, CustomAuthenticationProcessingFilter customSecurityFilter) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .addFilterAfter(customSecurityFilter, BasicAuthenticationFilter.class)
            .authorizeHttpRequests((authorize) -> 
                authorize.requestMatchers("/rest/v1/PublicService/**").permitAll()
                .requestMatchers("/rest/v1/UserService/login").permitAll()
                .requestMatchers("/rest/**").hasRole("USER")
            )
            
            .authenticationManager(authenticationManager)
            .cors(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable);;

        return http.build();
    }

    @Bean
    public SecurityContextRepository securityContextRepository(List<SecurityContextRepository> securityContextRepositoryList) {
        return new DelegatingSecurityContextRepository(securityContextRepositoryList);
    }
    
    @Bean
    public SecurityContextRepository requestAttributeSecurityContextRepository() {
        return new RequestAttributeSecurityContextRepository();
    }
    
    @Bean
    public SecurityContextRepository httpSessionSecurityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }
    
    public List<SecurityContextRepository> securityContextRepositoryList(
            RequestAttributeSecurityContextRepository requestAttributeSecurityContextRepository,
            HttpSessionSecurityContextRepository httpSessionSecurityContextRepository) {
        return List.of(
                requestAttributeSecurityContextRepository,
                httpSessionSecurityContextRepository
                );
    }
    
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
    
    @Bean
    public CustomAuthenticationProcessingFilter customSecurityFilter(AuthenticationManager authenticationManager) {
        return new CustomAuthenticationProcessingFilter(authenticationManager);
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userService, BCryptPasswordEncoder bcryptEncoder) {
        DatabaseAuthenticationProvider databaseAuthenticationProvider = new DatabaseAuthenticationProvider();
        databaseAuthenticationProvider.setUserDetailsService(userService);
        databaseAuthenticationProvider.setBcryptEncoder(bcryptEncoder);
        return databaseAuthenticationProvider;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
        return new ProviderManager(List.of(authenticationProvider));
    }
}
