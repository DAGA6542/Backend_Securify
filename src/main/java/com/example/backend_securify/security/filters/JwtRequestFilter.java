package com.example.backend_securify.security.filters;

import com.example.backend_securify.security.services.CustomUserDetailsService;
import com.example.backend_securify.security.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import org.springframework.security.core.GrantedAuthority;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public JwtRequestFilter(CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // --- Nuevos logs de depuración para la cabecera Authorization ---
        System.out.println("DEBUG JWT Filter: Solicitud entrante para URL: " + request.getRequestURI());
        if (authorizationHeader == null) {
            System.out.println("DEBUG JWT Filter: Cabecera 'Authorization' es NULA.");
        } else {
            System.out.println("DEBUG JWT Filter: Cabecera 'Authorization' encontrada: " + authorizationHeader);
            if (!authorizationHeader.startsWith("Bearer ")) {
                System.out.println("DEBUG JWT Filter: La cabecera 'Authorization' NO comienza con 'Bearer '.");
            }
        }
        // --- Fin de nuevos logs ---

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwt);
                System.out.println("DEBUG JWT Filter: Username extraído del token: " + username);
            } catch (ExpiredJwtException e) {
                System.out.println("DEBUG JWT Filter: Token JWT expirado: " + e.getMessage());
                username = null; // No procesar si el token está expirado
            } catch (SignatureException e) {
                System.out.println("DEBUG JWT Filter: Firma de token JWT inválida: " + e.getMessage());
                username = null; // No procesar si la firma es inválida
            } catch (Exception e) {
                System.out.println("DEBUG JWT Filter: Error inesperado al extraer username: " + e.getClass().getName() + " - " + e.getMessage());
                username = null;
            }
        }

        if (username != null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            System.out.println("DEBUG JWT Filter: UserDetails cargados para: " + userDetails.getUsername());
            System.out.print("DEBUG JWT Filter: Autoridades cargadas desde UserDetails: [");
            userDetails.getAuthorities().forEach(authority ->
                    System.out.print(authority.getAuthority() + ", ")
            );
            System.out.println("]");

            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                System.out.println("DEBUG JWT Filter: Autenticación establecida en SecurityContextHolder.");
                System.out.print("DEBUG JWT Filter: Autoridades en SecurityContextHolder después de establecer: [");
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(authority ->
                        System.out.print(authority.getAuthority() + ", ")
                );
                System.out.println("]");

            } else {
                System.out.println("DEBUG JWT Filter: Validación de token JWT fallida para el usuario: " + username);
                SecurityContextHolder.clearContext();
            }
        } else {
            System.out.println("DEBUG JWT Filter: No se encontró un token JWT válido o el username es nulo. No se intentará autenticar con JWT.");
        }
        chain.doFilter(request, response);
    }
}