package com.crud.controller;

import java.lang.System.Logger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.User;
import com.crud.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		log.info("controller is running");
		User createUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {

		return userService.updateUser(id, user);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> findAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(allUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUserByid(@PathVariable(value = "id") Long id) {

		User userById = userService.getUserById(id);

		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteuser(@PathVariable(value = "id") Long id) {

		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
