package com.adit.service;

import com.adit.entity.User;
import com.adit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void add(User user) {
		userRepository.add(user);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(long id) {
		return userRepository.getById(id);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

}
