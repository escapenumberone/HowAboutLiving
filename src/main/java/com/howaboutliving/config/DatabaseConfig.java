package com.howaboutliving.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/PublicDataEnvironment.xml"));
		sessionFactory.setTypeAliasesPackage("com.howaboutliving.dto");
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate session(SqlSessionFactory sqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}