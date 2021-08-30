package com.cj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CoronalVaccineSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoronalVaccineSystemApplication.class, args);
    }
}
