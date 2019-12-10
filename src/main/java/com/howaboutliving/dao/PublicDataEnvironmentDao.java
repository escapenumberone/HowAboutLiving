package com.howaboutliving.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howaboutliving.dto.PublicDataEnvironment;

@Repository
public class PublicDataEnvironmentDao {

	private SqlSession session;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public void insertPublicDataEnvironment(PublicDataEnvironment publicDataEnvironment) {
		session.insert("environment.insertPublicDataEnvironment", publicDataEnvironment);
	}
}
