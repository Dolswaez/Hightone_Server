package com.dolswaez.hightone_server.전역.스웨거.구성정보;

import org.springframework.context.annotation.Bean;
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
public class 스웨거_구성정보 {
    private static final String API_VERSION = "0.0.1-SNAPSHOT";
    private static final String API_TITLE = "우정기록부 API";
    private static final String API_DESCRIPTION = "돌쇄즈의 첫번째 프로젝트 우정기록부 입니다!";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dolswaez.hightone_server"))
                .paths(s -> true)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
}
