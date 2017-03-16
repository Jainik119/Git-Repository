package com.adit.repository;

import com.adit.entity.User;

import java.util.List;

public interface UserRepository {

	public void add(User user);

	public void delete(long id);

	public List<User> findAll();

	public User getById(long id);

	public void update(User user);
}
