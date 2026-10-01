package com.practiceday1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(ProductConfiguration.class);
	ProductDAO bean=context.getBean("product",ProductDAO.class);
	System.out.println("No.of.Rows are : ");
	System.out.println(bean.getNoOfRows());
	
}
}
