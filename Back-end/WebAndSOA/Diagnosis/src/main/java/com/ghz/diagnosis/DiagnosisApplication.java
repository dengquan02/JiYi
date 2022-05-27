package com.ghz.diagnosis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableFeignClients // 启用 OpenFeign
@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableRedisHttpSession//session共享
@MapperScan(value = {"com.ghz.diagnosis.dao"})
public class DiagnosisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnosisApplication.class, args);
    }

}
