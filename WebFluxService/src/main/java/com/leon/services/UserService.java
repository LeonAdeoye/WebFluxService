package com.leon.services;

import com.leon.models.User;
import com.leon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;

	public Flux<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	public Mono<User> getUser(String id)
	{
		return userRepository.findById(id);
	}
}
