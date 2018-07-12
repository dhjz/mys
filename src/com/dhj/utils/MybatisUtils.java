package com.dhj.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	private static SqlSessionFactory sessionFactory;
	
	static {
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
			sessionFactory = builder.build(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
