package com.practiceday3;

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
@ComponentScan(basePackages = "com.practiceday3")
@PropertySource("classpath:com/practiceday3/application.properties")
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
