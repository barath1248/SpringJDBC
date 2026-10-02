package com.practiceday2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MyMapper implements RowMapper<ProductBO> {

	public ProductBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductBO product=new ProductBO();
		product.setProduct_no(rs.getInt(1));
		product.setProduct_name(rs.getString(2));
		product.setAbout(rs.getString(3));
		product.setPrice(rs.getDouble(4));
		return product;
	}

}
