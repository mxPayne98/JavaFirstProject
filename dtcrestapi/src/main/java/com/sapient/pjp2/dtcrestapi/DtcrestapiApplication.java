package com.sapient.pjp2.dtcrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sapient.pjp2"})
public class DtcrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtcrestapiApplication.class, args);
    }

}
