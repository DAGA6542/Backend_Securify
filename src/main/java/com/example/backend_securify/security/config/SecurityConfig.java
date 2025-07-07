package com.example.backend_securify.security.config;

import com.example.backend_securify.security.filters.JwtRequestFilter;
import com.example.backend_securify.security.services.CustomUserDetailsService;

// **** CORRECCIÓN CRÍTICA 1: Importa el CorsFilter correcto de Spring Web ****
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// **** CORRECCIÓN CRÍTICA 2: Importa UrlBasedCorsConfigurationSource NO reactivo ****
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; // <-- ¡Este es el correcto!

import org.springframework.beans.factory.annotation.Value; // Para inyectar la propiedad ip.frontend
import java.util.Arrays; // Necesario para Arrays.asList()
import java.util.List;   // Para List.of() (opcional, ya que estás en Java 9+) y para el tipo List

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Value("${ip.frontend}") // Asegúrate de que esta propiedad esté definida en application.properties/yml
    private String frontendIp;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                // **** CORRECCIÓN 3: Habilita CORS en la cadena de seguridad ****
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/authenticate").permitAll()
                        // Puedes mantener .anyRequest().authenticated()
                        // porque @PreAuthorize se encarga de la lógica de roles en tus controladores
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // **** CORRECCIÓN 4: Define el CorsConfigurationSource bean ****
    // Este método proporciona la configuración CORS que será utilizada por el filtro de seguridad.
    // Ya NO necesitas un bean que devuelva un CorsFilter explícitamente aquí.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);

        // Divide la cadena de IPs. Arrays.asList() es la forma idiomática para arrays.
        List<String> allowedOrigins = Arrays.asList(frontendIp.split(","));
        configuration.setAllowedOrigins(allowedOrigins);

        // Para Java 17, puedes usar List.of() o Arrays.asList(). Ambos son válidos.
        // List.of() crea listas inmutables. Arrays.asList() crea listas de tamaño fijo (mutables en contenido).
        // Arrays.asList() es más común cuando conviertes arrays existentes.
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica la configuración a todas las rutas
        return source;
    }

    // **** CORRECCIÓN 5: ELIMINA ESTE MÉTODO COMPLETO (si lo tenías) ****
    // Ya no necesitas un bean que devuelva directamente un CorsFilter.
    // @Bean
    // public CorsFilter corsFilter() {
    //     // ... (código problemático) ...
    //     return new CorsFilter(source); // Esto es lo que causaba el error por la importación incorrecta y la forma de integración
    // }
}