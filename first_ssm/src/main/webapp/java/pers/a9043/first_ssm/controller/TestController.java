package pers.a9043.first_ssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.a9043.first_ssm.mapper.TestTableMapper;
import pers.a9043.first_ssm.pojo.TestTable;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestTableMapper testTableMapper;

    @GetMapping("/test")
    public TestTable test() {
        return testTableMapper.selectOne();
    }
}
