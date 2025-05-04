package com.theinhnam.schooldata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebappSchoolDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappSchoolDataApplication.class, args);
    }

}
