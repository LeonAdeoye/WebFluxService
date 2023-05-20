package com.leon.services;

import com.leon.models.Room;
import com.leon.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RoomService
{
	@Autowired
	private RoomRepository roomRepository;

	public Flux<Room> getAllRooms()
	{
		roomRepository.findAll().subscribe(System.out::println);
		return roomRepository.findAll();
	}

	public Mono<Room> getRoom(String id)
	{
		return roomRepository.findById(id);
	}
}
