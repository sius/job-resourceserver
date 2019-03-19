package io.liquer.greetingservice.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Component
public class GreetingsHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Mono<? extends Principal> principal = request.principal();
        Mono<String> s = principal.flatMap(
            p -> Mono.just(String.format("Hello, %1$s!", p.getName())));

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(s, String.class);
    }
}
