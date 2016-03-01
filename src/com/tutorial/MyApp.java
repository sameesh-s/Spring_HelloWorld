package com.tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tutorial.UserJDBCTemplate;

public class MyApp {

	   public static void main(String[] args) {
		   
		   
		   System.out.println("MyApp is running");
		      ApplicationContext context = 
		             new ClassPathXmlApplicationContext("Beans.xml");
		      System.out.println("Loading context is finished");
		      UserJDBCTemplate studentJDBCTemplate = 
		      (UserJDBCTemplate)context.getBean("userJDBCTemplate");
		      
		      System.out.println("------Records Creation--------" );
		      studentJDBCTemplate.create("Zara");
	   }
}
