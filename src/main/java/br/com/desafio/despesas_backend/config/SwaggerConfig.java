package br.com.desafio.despesas_backend.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("API para gerenciar as despesas e gerar os relatorios")
                        .description("Servicio para gerenciar e gerar os relatorios das despesas")
                        .version("0.0.1")
                );
    }
}