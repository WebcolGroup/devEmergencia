package com.cmc.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cmc.app.user.entity.User;
import com.cmc.app.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public List<User> findAll(User users) {
		return userService.findAll(users);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserbyUserId(@PathVariable("userId") Long userId) {
		User user = userService.getUserbyUserId(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		User users = userService.getUserbyUserId(userId);
		return ResponseEntity.ok(users);
	}

	@PostMapping("/save")
	public User save(@RequestBody User users) {
		return userService.save(users);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> edit(@RequestBody User users, @PathVariable Long id) {

		User userUp = userService.findById(id);

		if (userUp == null) {
			return ResponseEntity.notFound().build();
		}

		userUp.setName(users.getName());
		userUp.setSecondName(users.getSecondName());

		userService.save(userUp);
		return ResponseEntity.ok(users);

	}

	// SE CREA UPDATE POR MEDIO DE LA ANOTACION @Query
	@PutMapping("/updateq/{id}")
	public void update(@RequestBody User users, @PathVariable Long id) {
		User userUp = userService.findById(id);
		userUp.setName(users.getName());

		userService.update(userUp.getName(), userUp.getSecondName(), id);
	}

}
