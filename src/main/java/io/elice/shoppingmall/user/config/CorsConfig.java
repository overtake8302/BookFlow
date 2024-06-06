package io.elice.shoppingmall.user.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 3bd465834f53b723681605371ce84809a3467005
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
<<<<<<< HEAD
        config.addAllowedOrigin("*"); //모든 도메인 요청 허용
        config.addAllowedHeader("*"); //HTTP Header
=======
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*"); //HTTP Header
        config.setExposedHeaders(List.of("access"));
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
        config.addAllowedMethod("*"); //GET, POST, PUT, DELETE
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
