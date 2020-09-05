package com.example.demo.config;

import com.google.common.base.Predicates;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class for swagger documentation , [localhost:8080/swagger-ui.html]
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false).select().
                apis(RequestHandlerSelectors.basePackage("com.example.demo")).
                apis( Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).
                paths(PathSelectors.any()).build().apiInfo(metaData());
    }

    /**
     * @return
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo =
                new ApiInfo(
                        "Swagger UI",
                        "Demo Project",
                        "",
                        "",
                        new Contact("User APIs", "", ""),
                        "",
                        "",
                        new ArrayList<>());

        return apiInfo;
    }
}