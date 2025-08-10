package com.auth.check.json_check.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPIConfig {

    @Bean
    @Qualifier("basicSwagger")
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Swagger API").version("1.0").description("Documentation for Your Spring Boot API"));
    }
    
    @Bean
    @Primary
    public OpenAPI customOpenAPI1() {
        final String securitySchemeName = "bearerAuth"; // A name for your security scheme

        return new OpenAPI()
                .info(new Info()
                        .title("Your API Title")
                        .version("1.0")
                        .description("Documentation for Your Spring Boot API"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) // Apply globally
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName) // Name of the header, typically "Authorization"
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT") // Optional, but good for documentation
                                .description("JWT Bearer Token for API Authorization")));
       
    }
}
