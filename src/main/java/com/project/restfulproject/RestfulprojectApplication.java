package com.project.restfulproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class RestfulprojectApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestfulprojectApplication.class, args);
    }

    //deletemapping, putmapping을 사용하기 위한 bean추가
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
