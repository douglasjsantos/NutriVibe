package br.com.fiap.nutrivibe.nutrivibe.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain filtraCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(
                        Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()

                        .requestMatchers(HttpMethod.GET,"/security/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/security/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/security/usuarios").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,"/api/servicos").hasAnyRole("ADMIN","PROFISSIONAL")
                        .requestMatchers(HttpMethod.GET,"/api/servicos").hasAnyRole("USER","ADMIN","PROFISSIONAL")
                        .requestMatchers(HttpMethod.PUT,"/api/servicos").hasAnyRole("ADMIN","PROFISSIONAL")
                        .requestMatchers(HttpMethod.DELETE,"/api/servicos").hasAnyRole("ADMIN","PROFISSIONAL")

                        .requestMatchers(HttpMethod.POST,"/api/profissionais").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/profissionais").hasAnyRole("USER","ADMIN","PROFISSIONAL")
                        .requestMatchers(HttpMethod.PUT,"/api/profissionais").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/profissionais").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,"/api/feedback").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/api/feedback").hasAnyRole("USER","ADMIN","PROFISSIONAL")
                        .requestMatchers(HttpMethod.PUT,"/api/feedback").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE,"/api/feedback").hasAnyRole("USER","ADMIN")

                        .requestMatchers(HttpMethod.POST,"/api/agendamentos").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/api/agendamentos").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT,"/api/agendamentos").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE,"/api/agendamentos").hasAnyRole("USER","ADMIN")

                        .anyRequest()
                        .authenticated())
                .addFilterBefore(
                        verificarToken,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
