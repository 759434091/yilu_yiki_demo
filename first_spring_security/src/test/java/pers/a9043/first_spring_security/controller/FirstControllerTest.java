package pers.a9043.first_spring_security.controller;

import com.github.jwtsecurityspringbootstarter.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class FirstControllerTest {
    @Resource
    private JwtTokenUtils jwtTokenUtils;

    @Test
    public void test() {
        log.info(jwtTokenUtils.createJWT(new HashMap<>(), Calendar.MONTH, 1));
    }
}
