package pers.a9043.first_spring_security.controller;

import com.github.jwtsecurityspringbootstarter.annotation.TokenUser;
import com.github.jwtsecurityspringbootstarter.entity.JwtUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a9043
 */
@RestController
public class FirstController {
    @GetMapping("/resources")
    public String getResources(@TokenUser JwtUser jwtUser) {
        return "success";
    }
}
