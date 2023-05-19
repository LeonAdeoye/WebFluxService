package com.leon.repositories;

import com.leon.models.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {}
