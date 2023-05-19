package com.leon.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class ChatroomHandler
{
	public Mono<ServerResponse> getAllUsers(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(Flux.just(0,1,2,3).delayElements(Duration.ofSeconds(1)).log(), Integer.class));
	}

	public Mono<ServerResponse> getAllRooms(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(Flux.interval(Duration.ofMillis(500)).take(10).log(), Long.class));
	}
}
