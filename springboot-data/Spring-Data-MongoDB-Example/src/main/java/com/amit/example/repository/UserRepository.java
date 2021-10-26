package com.amit.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.amit.example.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
