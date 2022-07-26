package com.security.securityconfiguration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private PasswordEncoder bCrypt;

    @Bean
    public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.mvcMatchers("/hell").permitAll()
                        .mvcMatchers("/user**").authenticated()
        ).formLogin().and().httpBasic();
        http
                .logout().clearAuthentication(true)
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
        return http.build();
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager =
                new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("y")
                .password(bCrypt.encode("a"))
                .authorities("user")
                .build();
        inMemoryUserDetailsManager.createUser(user);
        return inMemoryUserDetailsManager;
    }*/
}
