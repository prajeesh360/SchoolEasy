package org.school.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SchoolEasySecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled  from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username =?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.authorizeHttpRequests(
        configure -> {
            configure.requestMatchers(HttpMethod.GET, "/v1/**").hasRole("GET");
            configure.requestMatchers(HttpMethod.POST, "/v1/**").hasRole("POST");
            configure.requestMatchers(HttpMethod.PUT, "/v1/**").hasRole("PUT");
            configure.requestMatchers(HttpMethod.DELETE, "/v1/**").hasRole("DELETE");
        });*/
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
