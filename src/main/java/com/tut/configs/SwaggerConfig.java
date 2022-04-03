package com.tut.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))  // urls that I want to be exposed in the documentation
                .apis(RequestHandlerSelectors.basePackage("com.tut"))  // this is package based config telling in which package to look. this exludes models
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "My Address Book API",
                "This is a tutorial I am doing to get familiar with Swagger",
                "1.0.OCTAV",
                "Feel free to use",
                new Contact("Octavian Morcov", "no url", "my@email.com"),
                "Api Licence (not sure what's for)",
                "licence url, don't have it",
                Collections.EMPTY_LIST
        );
    }
}
