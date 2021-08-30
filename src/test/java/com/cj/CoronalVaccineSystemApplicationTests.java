package com.cj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootTest
class CoronalVaccineSystemApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext ac = new FileSystemXmlApplicationContext("application-pro.yml");
        Object dosomething = ac.getBean("user");
        System.out.println(dosomething);
    }

}
