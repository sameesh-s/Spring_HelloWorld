package com.tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.ModelMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tutorial.UserJDBCTemplate;

@Controller
@SessionAttributes( {"user"}) 
public class HelloController {
	
	@RequestMapping("/Login")
	public String Login(ModelMap model){
		return "Login";
	}
	
	@RequestMapping("/Logout")
	public String Logout(ModelMap model , HttpSession session, SessionStatus status){
        status.setComplete();
        session.removeAttribute("user");
        model.remove("user");
		return "redirect:/Login";
	}
 
   @RequestMapping("/hello")
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      model.addAttribute("user", "stringvalue");
      return "hello";
   }
   
   @RequestMapping("/sucess")
   public String testSession(ModelMap model,HttpServletRequest request){
	   if(request.getSession().getAttribute("user")==null)
		   return "redirect:/Login";
	   else 
		   return "sucess";
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