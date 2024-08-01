package br.com.desafio.despesas_backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@ConfigurationProperties(prefix = "cors")
public class Cors {
    private String allowOrigins;
    private String allowMethods;
    private String allowHeaders;
    private String exposedHeaders;
    private int maxAge;
    private boolean allowCredentials;
    private String mapping;

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public void setAllowOrigins(String allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    public void setAllowMethods(String allowMethods) {
        this.allowMethods = allowMethods;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public void setExposedHeaders(String exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public String getAllowOrigins() {
        return allowOrigins;
    }

    public String getAllowMethods() {
        return allowMethods;
    }

    public String getAllowHeaders() {
        return allowHeaders;
    }

    public String getExposedHeaders() {
        return exposedHeaders;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public boolean getAllowCredentials() {
        return allowCredentials;
    }


    @Bean
    CorsFilter corsFilter() {
        var config = new CorsConfiguration();
        config.setAllowCredentials(this.getAllowCredentials());
        config.setAllowedOrigins(Arrays.asList(this.getAllowOrigins().split(",")));
        config.setAllowedHeaders(Arrays.asList(this.getAllowHeaders().split(",")));
        config.setAllowedMethods(Arrays.asList(this.getAllowMethods().split(",")));
        config.setMaxAge(Duration.ofSeconds(this.getMaxAge()));

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(this.getMapping(), config);

        return new CorsFilter(source);
    }
}
