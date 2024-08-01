package br.com.desafio.despesas_backend;

import br.com.desafio.despesas_backend.config.Cors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class DespesasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DespesasBackendApplication.class, args);
	}

}
