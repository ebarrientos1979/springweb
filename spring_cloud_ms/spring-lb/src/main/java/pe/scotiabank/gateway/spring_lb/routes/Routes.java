package pe.scotiabank.gateway.spring_lb.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> clienteServiceRoute(){
        return route("SPRING-CLOUD-CLIENTE")
                .GET("/v1/cliente/**", http())
                .POST("/api/v1/auth/**", http())
                .filter( lb("SPRING-CLOUD-CLIENTE") )
                .build();
    }
}
