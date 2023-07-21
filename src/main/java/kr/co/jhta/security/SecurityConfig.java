package kr.co.jhta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http
            .formLogin()
                .loginPage("/member/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .loginProcessingUrl("/member/login")
                .defaultSuccessUrl("/")
                .failureUrl("/member/login?error=fail")
            .and()
                .logout()
                .logoutUrl("/member/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
                .exceptionHandling().authenticationEntryPoint((req, res, handler) -> res.sendRedirect("/member/login?error=denied"))
            .and()
                .exceptionHandling().accessDeniedHandler((req, res, handler) -> res.sendRedirect("/member/login?error=forbidden"))
            .and()
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
