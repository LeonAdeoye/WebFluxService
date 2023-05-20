package com.leon.handlers;

import com.leon.models.Room;
import com.leon.models.User;
import com.leon.services.RoomService;
import com.leon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private RoomService roomService;
	@Autowired
	private UserService userService;

	public Mono<ServerResponse> getAllUsers(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(userService.getAllUsers().log(), User.class);
	}

	public Mono<ServerResponse> getAllRooms(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(roomService.getAllRooms().log(), Room.class);
	}

	public Mono<ServerResponse> getRoom(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(roomService.getRoom(request.queryParam("id").get()).log(), Room.class);
	}

	public Mono<ServerResponse> getUser(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(userService.getUser(request.queryParam("id").get()).log(), User.class);
	}

	public Mono<ServerResponse> intervals(ServerRequest request)
	{
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
				.body(BodyInserters.fromPublisher(Flux.interval(Duration.ofMillis(50)).take(5).log(), Long.class));
	}
}
