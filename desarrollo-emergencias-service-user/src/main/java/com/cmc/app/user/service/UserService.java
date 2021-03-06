package com.cmc.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.app.user.entity.User;
import com.cmc.app.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(User users) {
		return (List<User>) userRepository.findAll();
	}

	public User getUserbyUserId(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	/*
	 * public User findById(Long id) { return
	 * userRepository.findById(id).orElse(null); }
	 */

	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User findByUserId(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User users) {
		return userRepository.save(users);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public void update(String name, String secondName, Long id) {
		 userRepository.setUserInfoById(name, secondName, id);
	}

}
