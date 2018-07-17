package com.dhj.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dhj.domain.User;
import com.dhj.mapper.UserMapper;
import com.dhj.utils.MybatisUtils;

public class UserMapperTest {

	@Test
	public void testFindById() {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findById(12L);
		System.out.println(user.getUser_name()+":"+user.getUser_id());
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

}
