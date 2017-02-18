package com.rest.api;

import java.io.File;
import java.io.IOException; 
import java.io.InputStream;
import java.util.List;  
import java.util.Properties;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletResponse; 
import javax.ws.rs.Consumes; 
import javax.ws.rs.DELETE; 
import javax.ws.rs.FormParam; 
import javax.ws.rs.GET; 
import javax.ws.rs.OPTIONS; 
import javax.ws.rs.POST; 
import javax.ws.rs.PUT; 
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.Context; 
import javax.ws.rs.core.MediaType;  
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import com.rest.bean.User;
import com.rest.dao.UserDao;
@Path("/UserService") 

public class UserService { 
  
   UserDao userDao = new UserDao(); 
   User userBean = new User();
   
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers(){ 
      List<User> list = userDao.getAllUsers(); 
	  return list;
   }
   
   @GET 
   @Path("/usersjson") 
   @Produces({MediaType.APPLICATION_JSON}) 
   public List<User> getUsersJson(){ 
	   System.out.println("The Json Function is running");
	   List<User>users = userDao.getAllUsers();
	   System.out.println(users);
	   return users; 
   }
   
   @POST
   @Path("/register")
   @Consumes({MediaType.APPLICATION_JSON})
   public Response saveUser(User user){
	   String result = "";
	   if("null".equals(user)){
		   System.out.println("No content written");
		   return Response.noContent().build();
	   }else{
		   System.out.println("Inside the method");
		   
		   String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		   String sql = "INSERT INTO USER_DATA_MST (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
		   String dri = "oracle.jdbc.driver.OracleDriver";
		   String userDB = "system";
		   String passDB = "password";
		   
		   boolean result1 = userDao.createUser(user, url, userDB, passDB, sql, dri);
		   
	   		String fName = user.getfName();
	   		String lName = user.getlName();
	   		String email = user.getEmail();
	   		String pwd = user.getPass();
	   		
	   		System.out.println("Bean Values :");
	   		System.out.println("\tFirst Name :"+user.getfName());
	   		System.out.println("\tLast Name :"+user.getlName());
	   		System.out.println("\tEmail ID :"+user.getEmail());
	   		System.out.println("\tPassword :"+user.getPass());
	   		
	   		if(result1){
	   			return Response.ok(user,MediaType.APPLICATION_JSON).build();
	   		}else{
	   			return Response.serverError().build();
	   		}
	   }
   }
}