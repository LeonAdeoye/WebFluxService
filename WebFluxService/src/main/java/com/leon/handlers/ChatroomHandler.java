package com.leon.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ChatroomHandler
{
	public Mono<ServerResponse> getAllUsers(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(Flux.just(1,2,3), Integer.class));
	}

	public Mono<ServerResponse> getAllRooms(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(Flux.just(4,5,6), Integer.class));
	}
}
