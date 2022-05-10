package com.ghz.diagnosis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
// 配置了代理数据源,启动类排除掉数据源自动配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(value = {"com.ghz.diagnosis.dao"})
public class DiagnosisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnosisApplication.class, args);
    }

}
