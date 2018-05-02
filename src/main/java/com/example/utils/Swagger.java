package com.example.utils;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @create 2018-03-13 15:48
 **/
@Configuration
public class Swagger {

    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example.controller")).paths(PathSelectors.any()).build();
        return docket;
    }

    private ApiInfo apiInfo() {
       ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("springboot 利用swagger2构建api文档");
        apiInfoBuilder.description("Restful风格");
        apiInfoBuilder.version("1.0");
        return apiInfoBuilder.build();

    }
}