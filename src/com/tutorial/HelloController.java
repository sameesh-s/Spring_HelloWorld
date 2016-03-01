package com.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tutorial.UserJDBCTemplate;

@Controller
public class HelloController {
 
   @RequestMapping("/won")
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
   }
   
   @RequestMapping("/ajax")
   public String checkAjax(ModelMap model){
	   return "load";
   }
   
   @RequestMapping("/chatbox")
   public String chatBox(ModelMap model){
	   return "chatbox";
   }
   @RequestMapping("/insert")
   public String JDBCinsertion(ModelMap model){

	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
	      UserJDBCTemplate studentJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	      studentJDBCTemplate.create("Sam");
	      return "sucess";
   }
}