package com.allei.helloword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebFluxRoutingConfiguration {

    @Autowired
    private UserHandler userHandler;

    @Bean("routerFunction")
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/webflux/user/{userId}"), userHandler::getUserById)
                .andRoute(RequestPredicates.GET("/webflux/users"),userHandler::getAllUser);
    }

}