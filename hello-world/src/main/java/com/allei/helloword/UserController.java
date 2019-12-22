package com.allei.helloword;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by allei on 2019/12/22.
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepository userRepository;

    @GetMapping("user/{id}")
    public Mono<User> getUser(@PathVariable("id") Integer id){
        logger.info("getUser,id={}",id);
        return Mono.just(userRepository.getUserById(id));
    }

    @PostMapping("user")
    public Mono<User> addUser(@RequestBody User user){
        logger.info("getUser,id={}",user);
        return Mono.just(userRepository.addUser(user));
    }
    @GetMapping("users")
    public Flux<User> getAll(){
        logger.info("users");
        return Flux.fromStream(userRepository.getUsers().stream());
    }
}
