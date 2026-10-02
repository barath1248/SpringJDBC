package com.practiceday2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practiceday2.ProductConfiguration;

public class Main {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(ProductConfiguration.class);
	ProductDAO bean = context.getBean(ProductDAO.class);
	System.out.print("ProductName is : ");
	System.out.println(bean.getProductName(102));
	System.out.println(bean.getByID(102));
}
}
