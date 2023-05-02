package id.co.bca.funtravel.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import id.co.bca.funtravel.customer.service.MyUserDetailService;

@Configuration
public class SecurityConfiguration {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/customer?id=1")
                .and()
                .logout().permitAll().logoutSuccessUrl("/login");

        return http.build();
    }
}
