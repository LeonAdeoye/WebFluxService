package com.leon.routers;

import com.leon.handlers.ChatroomHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ChatroomRouter
{
	@Bean
	public RouterFunction<ServerResponse> chatroomRoutes(ChatroomHandler chatroomHandler)
	{
		return route(GET("/users").and(accept(MediaType.APPLICATION_JSON)), chatroomHandler::getAllUsers)
				.andRoute(GET("/rooms").and(accept(MediaType.APPLICATION_JSON)), chatroomHandler::getAllRooms)
				.andRoute(GET("/intervals").and(accept(MediaType.TEXT_EVENT_STREAM)), chatroomHandler::intervals)
				.andRoute(GET("/room").and(accept(MediaType.APPLICATION_JSON)), chatroomHandler::getRoom)
				.andRoute(GET("/user").and(accept(MediaType.APPLICATION_JSON)), chatroomHandler::getUser);
	}
}
