package io.elice.shoppingmall.user.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); //모든 도메인 요청 허용
        config.addAllowedHeader("*"); //HTTP Header
        config.addAllowedMethod("*"); //GET, POST, PUT, DELETE
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
