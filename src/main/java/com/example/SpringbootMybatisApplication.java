package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.example.mapper")
@EnableSwagger2
class SpringbootMybatisApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }


}
