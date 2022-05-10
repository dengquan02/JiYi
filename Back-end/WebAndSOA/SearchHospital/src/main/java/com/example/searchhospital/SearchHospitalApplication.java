package com.example.searchhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class SearchHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchHospitalApplication.class, args);
    }

}
