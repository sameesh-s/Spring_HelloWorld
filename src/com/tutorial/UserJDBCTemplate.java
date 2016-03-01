package com.tutorial;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }
	   
	   public void create(String name) {
		      String SQL = "insert into user (name) values (?)";
		      
		      jdbcTemplateObject.update( SQL, name);
		      //System.out.println("Created Record Name = " + name );
		      return;
		   } 
	   

	   public User getUser(String name) {
	      String SQL = "select * from user where name = '?'";
	      User user = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{name}, new UserMapper());
	      return user;
	   }
	   
	   public List<User> listUser() {
		      String SQL = "select * from user";
		      List <User> users = jdbcTemplateObject.query(SQL, 
		                                new UserMapper());
		      return users;
		   }
	   
	   public void delete(String name){
		      String SQL = "delete from Student where name = '?'";
		      jdbcTemplateObject.update(SQL, name);
		      //System.out.println("Deleted Record with ID = " + id );
		      return;
		   }
	   
	   public void update(String name){
		      String SQL = "update Student set name = '?' where name = '?'";
		      jdbcTemplateObject.update(SQL, name , name);
		      //System.out.println("Updated Record with ID = " + id );
		      return;
		   }
}
