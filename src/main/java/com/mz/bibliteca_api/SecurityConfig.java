package com.mz.bibliteca_api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mz.bibliteca_api.entity.Usuario;
import com.mz.bibliteca_api.iservice.IUsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
            .csrf(Customizer.withDefaults())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/api/usuarios").hasRole("ADMIN")
                    .requestMatchers("/api/usuarios/me").authenticated()
                    .requestMatchers("/api/usuarios/register").permitAll()
                    .requestMatchers("/api/usuarios/csrf").permitAll()
                    .requestMatchers("/api/alumnos").hasRole("ADMIN")
                    .requestMatchers("/api/alumnos/me").authenticated()
                    .requestMatchers("/api/profesores").hasRole("ADMIN")
                    .requestMatchers("/api/profesores/me").authenticated()
                    .requestMatchers("/api/cursos").hasRole("ADMIN")
                    .requestMatchers("/api/cursos/me").authenticated()
                    .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                )
                .logout((logout) -> {
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/login?logout");
                    logout.permitAll();
                });

		return http.build();
	}

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1", "https://127.0.0.1/", "http://localhost/", "https://localhost", "http://127.0.0.1:3000", "https://127.0.0.1:3000/", "http://localhost:3000/", "https://localhost:3000/", "http://localhost:8080/", "https://localhost:8080/"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    private IUsuarioService uService;
    
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        List<Usuario> usuarios = uService.findAllUsuarios();

        for (Usuario usuario : usuarios) {
            UserDetails userDetails = User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .build();
            
            manager.createUser(userDetails);
        }

        return manager;
    }
}
