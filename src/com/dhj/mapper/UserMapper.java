package com.dhj.mapper;

import com.dhj.domain.User;

public interface UserMapper {

	User findById(Long id);
	
	void save(User user);
}
