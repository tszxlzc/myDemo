package lzc.springboot.config;

import lzc.springboot.model.User;
import lzc.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * Created by liuzc on 2019/3/24.
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionAllUsers(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
//        Mono<Collection<User>> mono = Mono.just(users);
        return RouterFunctions.route(RequestPredicates.path("/all-users"),
                request -> ServerResponse.ok().body(userFlux,User.class));
    }

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionUsers(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
//        Mono<Collection<User>> mono = Mono.just(users);
        return RouterFunctions.route(RequestPredicates.path("/users"),
                request -> ServerResponse.ok().body(userFlux,User.class));
    }

}