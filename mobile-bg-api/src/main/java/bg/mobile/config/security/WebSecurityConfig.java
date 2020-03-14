package bg.mobile.config.security;

import static bg.mobile.config.security.SecurityConstants.CARS_URL;
import static bg.mobile.config.security.SecurityConstants.USERS_URL;

import bg.mobile.config.security.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, USERS_URL, CARS_URL).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(final WebSecurity web) {
    web.ignoring().antMatchers(
        "/configuration/ui",
        "/configuration/**",
        "/actuator/**",
        "/v2/api-docs",
        "/swagger-resources/**",
        "/swagger-ui.html",
        "/webjars/**");
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }

}
