package com.dhj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dhj.domain.User;
import com.dhj.utils.MybatisUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findById(Long id) {

		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("user.findById", id);
		session.commit();
		session.close();
		return user;
	}

	@Override
	public void save(User user) {

		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		session.insert("user.insertUser", user);
		session.commit();
		session.close();
	}

}
