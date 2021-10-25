package com.amit.example.services;

import java.util.List;

import com.amit.example.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	int getUserAge(String userId);

	String addUserAge(String userId, int age);
}