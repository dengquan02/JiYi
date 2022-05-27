package com.example.reservation;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;
//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@EnableAdminServer
//@EnableAdminServer
@EnableFeignClients // 启用 OpenFeign
@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableRedisHttpSession//session共享
@MapperScan(value = {"com.example.reservation.dao"})
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

}
