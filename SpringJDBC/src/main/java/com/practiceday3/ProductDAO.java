package com.practiceday3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository("product")
public class ProductDAO {
    
	private static final String QUERY_FOR_INSERT="insert into product (product_no,product_name,about,price) values (?,?,?,?)";
	
	private static final String QUERY_FOR_GETALLDETAILS="select * from product";
	
	private static final String QUERY_FOR_UPDATE="update product set price=? where product_no=?";
	
	private static final String QUERY_FOR_DELETION="delete from product where product_no=?";
	private JdbcTemplate template;
	
	@Autowired
	ProductDAO(JdbcTemplate template){
		this.template=template;
	}
	
	public int insertProductDetails(ProductBO product){
		return template.update(QUERY_FOR_INSERT, new Object[] {product.getProduct_no(),
				                                                       product.getProduct_name(),
				                                                       product.getAbout(),
				                                                       product.getPrice()			                                                       
		});
	}
	public List<ProductBO> getAllDetais(){
		return template.query(QUERY_FOR_GETALLDETAILS,
				(rs,row)->{
					ProductBO product=new ProductBO();
					product.setProduct_no(rs.getInt(1));
					product.setProduct_name(rs.getString(2));
					product.setAbout(rs.getString(3));
					product.setPrice(rs.getDouble(4));
					return product;		
				});
	}
	
	public int updateDetails(double price, int product_no) {
		return template.update(QUERY_FOR_UPDATE,new Object[] {price,product_no});
	}
	
	public int deletion(int product_no) {
		return template.update(QUERY_FOR_DELETION, new Object[] {product_no});
	}
}
