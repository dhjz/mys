package com.dhj.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dhj.dao.UserDao;
import com.dhj.dao.UserDaoImpl;
import com.dhj.domain.User;

public class UserDaoTest {

	@Test
	public void testFindById() {
		UserDao userdao = new UserDaoImpl();
		User user = userdao.findById(15L);
		System.out.println(user.getUser_name()+":"+user.getUser_id());
	}
	
	@Test
	public void testSave() {
		UserDao userdao = new UserDaoImpl();
		User user = new User();
		user.setUser_code("dhj3");
		user.setUser_name("丁浩君3");
		user.setUser_password("323213213");
		user.setUser_state("0");
		userdao.save(user);
	}

}
