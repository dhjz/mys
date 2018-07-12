package com.dhj.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dhj.domain.User;
import com.dhj.utils.MybatisUtils;

public class TestMy {

	@Test
	public void testById(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		User user = openSession.selectOne("user.findById", 12L);
		System.out.println(user.getUser_name()+"***"+user.getUser_code());
		openSession.close();
	}
	@Test
	public void testInsert(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setUser_code("dhj111");
		user.setUser_name("made");
		user.setUser_password("dsafadsfdasfad");
		user.setUser_state("0");
		openSession.insert("user.insertUser", user);
		openSession.commit();
		openSession.close();
	}
}
