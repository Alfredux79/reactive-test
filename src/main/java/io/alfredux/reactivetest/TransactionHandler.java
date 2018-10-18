package io.alfredux.reactivetest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TransactionHandler {

    public Mono<ServerResponse> test(ServerRequest request){
      log.info("TEST ROUTER FUNCTION HANDLER {}",request.path());
      return Mono.empty();
    }
}
