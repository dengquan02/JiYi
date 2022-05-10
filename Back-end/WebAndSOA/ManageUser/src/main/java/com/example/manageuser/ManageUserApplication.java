package com.example.manageuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class ManageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageUserApplication.class, args);
    }

}
