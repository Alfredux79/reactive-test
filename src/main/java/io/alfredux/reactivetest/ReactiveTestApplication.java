package io.alfredux.reactivetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class ReactiveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveTestApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> route(TransactionHandler transactionHandler){
		return RouterFunctions.route(RequestPredicates.GET("/test"),transactionHandler::test);
	}
}
