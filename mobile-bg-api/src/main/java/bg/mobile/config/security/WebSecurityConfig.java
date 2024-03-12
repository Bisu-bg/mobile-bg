package bg.mobile.config.security;

import bg.mobile.config.security.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static bg.mobile.config.security.SecurityConstants.USERS_URL;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    @Order(1)
    public SecurityFilterChain configurePublicEndpoints(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .securityMatcher(AUTH_WHITELIST)
                .authorizeHttpRequests(requests ->
                        requests.anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers( USERS_URL, "/cars/**").permitAll()
                                .anyRequest().authenticated());
        http.addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    private static final String[] AUTH_WHITELIST = {
            "/cars/all",
            // -- Swagger UI v2
            "/v2/api-docs",
            "v2/api-docs",
            "/swagger-resources",
            "swagger-resources",
            "/swagger-resources/**",
            "swagger-resources/**",
            "/configuration/ui",
            "configuration/ui",
            "/configuration/security",
            "configuration/security",
            "/swagger-ui.html",
            "swagger-ui.html",
            "webjars/**",
            // -- Swagger UI v3
            "/v3/api-docs/**",
            "v3/api-docs/**",
            "/swagger-ui/**",
            "swagger-ui/**",
            // CSA Controllers
            "/csa/api/token",
            // Actuators
            "/actuator/**",
            "/health/**"
    };
}