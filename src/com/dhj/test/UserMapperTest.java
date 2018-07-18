package com.dhj.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dhj.domain.QueryVo;
import com.dhj.domain.User;
import com.dhj.domain.Visit;
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
	
	@Test
	public void findByIdQueryVo() {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUser_name("丁");
		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		List<User> list = userMapper.findByIdQueryVo(queryVo);
		for (User user2 : list) {
			System.out.println(user2.getUser_name()+":"+user2.getUser_id());
		}
		
	}
	
	@Test
	public void findByName(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUser_name("丁");
		user.setUser_id(13L);
		List<User> list = userMapper.findByName(user);
		for (User user2 : list) {
			System.out.println(user2.getUser_name()+":"+user2.getUser_id());
		}
	}
	
	@Test
	public void findVisitAndUser(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<Visit> visits = userMapper.findVisitAndUser();
		for (Visit visit : visits) {
			System.out.println(visit.getVisit_id()+":对应的username："+visit.getUser().getUser_name());
		}
	}
	
	@Test
	public void findUserAndVisit(){
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserAndVisit();
		for (User user2 : user) {
			if (user2.getVisits() != null) {
				System.out.print(user2.getUser_name()+":对应的订单号是。。。  ");
				List<Visit> visits = user2.getVisits();
				for (Visit visit : visits) {
					System.out.print(visit.getVisit_id()+"、");
//					System.out.println(visit);
				}
				System.out.print("\n");
			}
		}
	}
	
	

}
