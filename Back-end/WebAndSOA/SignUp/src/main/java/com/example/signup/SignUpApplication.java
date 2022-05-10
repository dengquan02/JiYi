package com.example.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class SignUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignUpApplication.class, args);
    }

}
