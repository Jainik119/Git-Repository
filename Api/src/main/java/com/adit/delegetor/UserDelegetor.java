package com.adit.delegetor;

import com.adit.entity.User;
import com.adit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDelegetor {

	@Autowired
	private UserService userService;

	public void add(User user) {
		userService.add(user);
	}

	public void delete(long id) {
		userService.delete(id);
	}

	public List<User> findAll() {
		return userService.findAll();
	}

	public User getById(long id) {
		return userService.getById(id);
	}

	public void update(User user) {
		userService.update(user);
	}

}
