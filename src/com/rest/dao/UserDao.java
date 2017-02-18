package com.rest.dao;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream;
import java.io.ObjectOutputStream; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.List;  
import java.util.Properties;

import com.rest.bean.User;

public class UserDao { 
   public List<User> getAllUsers(){ 
      List<User> userList = null; 
      User user = new User("Mahesh", "Teacher", "mahesh@afd.com", "asdaksd"); 
      userList = new ArrayList<User>(); 
      userList.add(user); 
      return userList; 
   }  

   public Connection getConnection(String url, String userDB, String passDB){
	   Connection con = null;
	   try {
		   con = DriverManager.getConnection(url, userDB, passDB);
		   return con;
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		}
   }
   
   public boolean createUser(User user, String url, String userDB, String passDB, String sql, String driver){
	   boolean result = false;
	   try {
		Class.forName(driver);
		Connection con = getConnection(url, userDB, passDB);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getfName());
		stmt.setString(2, user.getlName());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPass());
		int res = stmt.executeUpdate();
		if(res>0){
			result = true;
		}else{
			result = false;
		}
		return result;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return result;
	}   
   }
   
}