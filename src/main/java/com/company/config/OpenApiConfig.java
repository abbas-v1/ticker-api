package com.company.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Open API configuration
 *
 * @see Swagger UI : /swagger-ui/index.html
 * @see Open API JSON doc : /v3/api-docs
 * @see Open API YAML doc : /v3/api-docs.yaml
 *
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String apiVersion) {
        return new OpenAPI().info(
            new Info()
                .title("Market Maker Service API")
                .version(apiVersion)
        );
    }

}
