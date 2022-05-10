package com.example.searchdoctor;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class SearchDoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchDoctorApplication.class, args);
    }

}
