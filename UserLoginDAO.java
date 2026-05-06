package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO 
{
  UserBean ub = null;
  
  public UserBean CheckLogin(String username,String password)
  {
	
	  try
	  {
		  Connection Con = DbConnect.getcon();
		  PreparedStatement pstmt = Con.prepareStatement("select * from registration where username=? and password=?");
		  pstmt.setString(1, username);
		  pstmt.setString(2, password);
		  ResultSet rs = pstmt.executeQuery();
		  if(rs.next())
		  {
			  ub = new UserBean();
			  ub.setU_username(rs.getString(1));
			  ub.setU_password(rs.getString(2));
			  ub.setU_firstname(rs.getString(3));
			  ub.setU_lastname(rs.getString(4));
			  ub.setU_mailid(rs.getString(5));
			  ub.setU_phone(rs.getString(6));

		  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  return ub;
	  
  }
}
