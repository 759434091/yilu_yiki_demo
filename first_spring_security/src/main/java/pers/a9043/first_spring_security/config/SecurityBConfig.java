package pers.a9043.first_spring_security.config;

import com.github.jwtsecurityspringbootstarter.JwtTokenUtils;
import com.github.jwtsecurityspringbootstarter.config.JwtConfigurer;
import com.github.jwtsecurityspringbootstarter.entity.JwtUser;
import com.github.jwtsecurityspringbootstarter.entity.JwtUserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 采用自动配置
 *
 * @author a9043
 */
@Configuration
public class SecurityBConfig extends WebSecurityConfigurerAdapter {
    @Bean
    JwtUserFactory jwtUserFactory() {
        return claims -> new JwtUser() {
            @Override
            public Object getPrincipal() {
                return "principal";
            }

            @Override
            public Object getCredentials() {
                return "credentials";
            }

            @Override
            public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
                return new ArrayList<>();
            }
        };
    }

    @Bean
    JwtTokenUtils jwtTokenUtils() {
        return new JwtTokenUtils("a9043", "123");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer<>(jwtTokenUtils(), jwtUserFactory()))
                .and()
                .exceptionHandling();
    }
}
