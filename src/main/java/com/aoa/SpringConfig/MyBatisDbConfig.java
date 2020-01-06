package com.aoa.SpringConfig;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = { "com.aoa.Repository" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisDbConfig {
	@Autowired
	private DataSource dataSource;

	@Bean
	@Primary
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sql =new SqlSessionFactoryBean();
		sql.setDataSource(dataSource);
		return sql.getObject();
	}

}
