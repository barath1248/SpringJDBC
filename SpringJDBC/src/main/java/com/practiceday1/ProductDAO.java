package com.practiceday1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("product")
public class ProductDAO {
  
 private static final String  QUERY_FOR_NO_ROWS="select count(1) from product";
 
  private JdbcTemplate jdbctemplate;
  
  @Autowired
  ProductDAO(JdbcTemplate jdbcTemplate){
	  this.jdbctemplate=jdbcTemplate;
  }
  
  public int getNoOfRows() {
	  return jdbctemplate.queryForObject(
			  QUERY_FOR_NO_ROWS,
			  Integer.class);
  }
  
}
