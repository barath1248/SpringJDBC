package com.practiceday3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(ProductConfiguration.class);
	ProductDAO bean=context.getBean("product",ProductDAO.class);
	
	System.out.println(bean.getAllDetais());
	
	System.out.println("Inserting the data");
	ProductBO product=new ProductBO();
	product.setProduct_no(104);
	product.setProduct_name("Speaker");
	product.setAbout("Bluetooth Speaker");
	product.setPrice(2100);
	int insertion=bean.insertProductDetails(product);
	if(insertion>0) {
		System.out.println("Inserted successfully!");
	}
	else {
		System.out.println("Try again");
	} 
	

	int updation=bean.updateDetails(1700, 104);
	if(updation>0) {
		System.out.println("Updated successfully!");
	}
	else {
		System.out.println("Try again");
	} 
	
	int deletion=bean.deletion(104);
	if(deletion>0) {
		System.out.println("Deleted Successfully!");
	}
	else {
		System.out.println("Try again");
	}
	  
}
}
