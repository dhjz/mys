package com.dhj.dao;

import com.dhj.domain.User;

public interface UserDao {
	User findById(Long id);
	
	void save(User user);
}
