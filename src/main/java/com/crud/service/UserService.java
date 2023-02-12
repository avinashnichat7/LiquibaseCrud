package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.entity.User;

@Service
public interface UserService {

	public User createUser(User user);

	public List<User> getAllUser();

	public User getUserById(Long Id);

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);
}
