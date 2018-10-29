package pers.a9043.first_spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class FirstBeanTest {
    // java内置日志记录器
    private Logger logger = Logger.getGlobal();
    // Resource 注解表示默认先按名称装入bean
    // 此处firstBean将有Spring自动注入
    @Resource
    private FirstBean firstBean;

    @Test
    public void test() {
        logger.info(firstBean.getName());
    }
}
