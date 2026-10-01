package com.practiceday1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource("classpath:com/practiceday1/application.properties")
@ComponentScan(basePackages = "com.practiceday1")
public class ProductConfiguration {
	
    @Autowired
	Environment environment;
    
    @Bean
    public DataSource datasource() {
    	DriverManagerDataSource source=new DriverManagerDataSource();
		source.setDriverClassName(environment.getProperty("db.drivername"));
		source.setUrl(environment.getProperty("db.url"));
		source.setUsername(environment.getProperty("db.username"));
		source.setPassword(environment.getProperty("db.password"));
		return source;
		}
    
    @Bean
    public JdbcTemplate jdbctemplate() {
    	JdbcTemplate template=new JdbcTemplate(datasource());
    	return template;
    }
}
