package com.adit.service;

import com.adit.entity.User;

import java.util.List;

public interface UserService {

	public void add(User user);

	public void delete(long id);

	public List<User> findAll();

	public User getById(long id);

	public void update(User user);
}
