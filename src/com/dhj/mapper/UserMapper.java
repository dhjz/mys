package com.dhj.mapper;

import java.util.List;

import com.dhj.domain.QueryVo;
import com.dhj.domain.User;
import com.dhj.domain.Visit;

public interface UserMapper {

	User findById(Long id);
	
	void save(User user);
	
	List<User> findByIdQueryVo(QueryVo queryVo);
	List<User> findByName(User user);
	
	List<Visit> findVisitAndUser();
	
	List<User> findUserAndVisit();
}
