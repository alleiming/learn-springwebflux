package com.allei.helloword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private Logger logger = LoggerFactory.getLogger(UserHandler.class);

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        logger.info("getUserById");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.just(userRepository.getUserById(Integer.valueOf(serverRequest.pathVariable("userId")))), User.class);
    }


    public Mono<ServerResponse> getAllUser(ServerRequest serverRequest) {
        logger.info("getAllUser");
        Flux<User> userFlux = Flux.fromStream(userRepository.getUsers().stream());
        return ServerResponse.ok()
                .body(userFlux, User.class);
    }
}