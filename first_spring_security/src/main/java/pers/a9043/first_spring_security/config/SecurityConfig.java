package pers.a9043.first_spring_security.config;

import com.github.jwtsecurityspringbootstarter.JwtConfigurer;
import com.github.jwtsecurityspringbootstarter.JwtTokenUtils;
import com.github.jwtsecurityspringbootstarter.config.JwtUserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    JwtUserFactory jwtUserFactory() {
        return claims -> null;
    }

    @Bean
    JwtTokenUtils jwtTokenUtils() {
        return new JwtTokenUtils("a9043", "123");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer<>())
                .and()
                .exceptionHandling();
    }
}
