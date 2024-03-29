package com.softuni.book.security.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(
                new Info()
                        .title("SoftUni book API")
                        .contact(
                                new Contact()
                                        .email("softuni@book-api.com").name("Student")
                        )
                        .description("Small API for books/authors and some other funny stuff description!")
        );
    }
}
