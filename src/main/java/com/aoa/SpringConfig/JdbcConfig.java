package com.aoa.SpringConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** @Configuration：声明一个类作为配置类，代替xml文件
* @Bean：声明在方法上，将方法的返回值加入Bean容器，代替<bean>标签
* @value：属性注入
* @PropertySource：指定外部属性文件，
*/


@Configuration

public class JdbcConfig {
	private String url="jdbc:postgresql://192.168.1.94:5432/wjuandb?useUnicode\\=true&characterEncoding\\=UTF-8\r\n";
	  private String driver="org.postgresql.Driver";
	    private String username="wjuan";
	    private String password="wjuan";

	    @Bean(name = "datasouce")
	    public DataSource dataSource(){
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driver);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }

}
