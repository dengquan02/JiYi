//package com.example.config;
//
////import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
///**
// * @author: Gu HungJou
// * @date: 2021/11/4 13:10
// * Describe:
// */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//public class SwaggerConf {
//        @Bean
//        public Docket docker() {
//            return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
//                    "软工课设的swaggerAPI文档",
//                    "ghz",
//                    "v1.0",
//                    "47.102.148.102:9540",
//                    new Contact("ghz", "tongji.edu.cn", "1213618635"),
//                    "Apache 2.0",
//                    "http://www.apache.org/licenses/LICENSE-2.0",
//                    new ArrayList<>()
//            )).select()
//                    .apis(RequestHandlerSelectors.any())
//                    .paths(PathSelectors.regex("(?!/error.*).*"))
//                    .build();
//        }
//}
////  .apis(RequestHandlerSelectors.basePackage("com.ghz.log.controller"))
