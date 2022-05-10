package com.dq.itemmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@MapperScan("com.dq.itemmanager.mapper")
public class ItemManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemManagerApplication.class, args);
    }

}
