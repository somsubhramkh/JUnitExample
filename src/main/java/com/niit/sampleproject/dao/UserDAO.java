package com.niit.sampleproject.dao;

import java.util.List;

import com.niit.sampleproject.model.User;

public interface UserDAO {
	
	public List<User> list();
	
	public User get(String username);
	
	public boolean save(User user);
	
	public boolean updateUser(User user);
	
	public boolean delete(User user);
	
}
