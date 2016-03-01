package com.tutorial;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the Student table.
    */
   public void create(String name);
   /** 
    * This is the method to be used to list down
    * a record from the Student table corresponding
    * to a passed student id.
    */
   public List<User> listUser();
   /** 
    * This is the method to be used to delete
    * a record from the Student table corresponding
    * to a passed student id.
    */
   public void delete(String name);
   /** 
    * This is the method to be used to update
    * a record into the Student table.
    */
   public void update(String name);
}