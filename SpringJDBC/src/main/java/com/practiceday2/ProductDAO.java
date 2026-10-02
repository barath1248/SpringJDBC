package com.practiceday2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("product")
public class ProductDAO {
	
	private static final String QUERY_FOR_PRODUCTNAME_BYID =
			"select product_name from product where PRODUCT_NO=?";
	private static final String QUERY_FOR_ALLDETAIL_BYID =
			"select product_no,product_name,about,price " +
			"from product where product_no=?";
			
	 private JdbcTemplate jdbctemplate;
	  
	  @Autowired
	  ProductDAO(JdbcTemplate jdbcTemplate){
		  this.jdbctemplate=jdbcTemplate;
	  }
	  
	  public String getProductName(int productId) {
		 return jdbctemplate.queryForObject(QUERY_FOR_PRODUCTNAME_BYID, String.class, new Object[] {productId});
	  }
	  
	  @SuppressWarnings("deprecation")
	public ProductBO getByID(int productId) {
		  return jdbctemplate.queryForObject(QUERY_FOR_ALLDETAIL_BYID,new Object[] { productId }, new MyMapper());
	  }
}
