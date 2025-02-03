package com.tn.ConfigSecuriry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }
//    tạo ra một Docket bean. Docket là một cấu hình chính của Swagger.
//    Nó cung cấp các phương thức để cấu hình các thông tin như tiêu đề, mô tả, liên hệ, v.v. của API.
//    Nó cũng cho phép bạn cấu hình các API nào sẽ được hiển thị trong tài liệu.

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Test API",
                "Some custom description of API.",
                "API",
                "Terms of service",
                new Contact("Nguyễn Dũng", "www.example.com", "supervitmomo@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
//    tạo ra một ApiInfo object, nó chứa thông tin chi tiết về API như tiêu đề, mô tả, thông tin liên hệ

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
//    tạo ra một ApiInfo object, nó chứa thông tin chi tiết về API như tiêu đề, mô tả, thông tin liên hệ
}