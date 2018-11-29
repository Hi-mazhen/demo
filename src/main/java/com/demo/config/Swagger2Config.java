package com.demo.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {
//    @Value("${swagger2.enable}") private boolean enable;

//    @Bean("UserApis")
    @Bean
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/user.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(true);
    }

//    @Bean("CustomApis")
//    public Docket customApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("客户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/custom.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("demo接口文档")
                .description("提供文档")
                .termsOfServiceUrl("https://xingtian.github.io/trace.github.io/")
                .version("1.0")
                .build();
    }
}
