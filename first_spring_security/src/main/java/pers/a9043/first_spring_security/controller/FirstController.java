package pers.a9043.first_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/resources")
    public String getResources() {
        return "success";
    }
}
