package pe.scotiabank.gateway.spring_lb.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> clienteServiceRoute() {
        return route("SPRING-CLOUD-CLIENTE")
                .GET("/v1/cliente/**", http())
                .POST("/api/v1/auth/**", http())
                .filter( lb("SPRING-CLOUD-CLIENTE") )
                .build();
    }



    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // Permitir envío de credenciales como cookies o encabezados de autenticación
        config.addAllowedOriginPattern("*");  // Permitir todos los orígenes
        config.addAllowedHeader("*");  // Permitir todos los headers
        config.addAllowedMethod("*");  // Permitir todos los métodos (GET, POST, PUT, DELETE, etc.)
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}