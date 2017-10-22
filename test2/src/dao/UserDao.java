package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoinf.IUserDao;

import bean.User;

public class UserDao implements IUserDao{
	DBconn conn=new DBconn();
	public  boolean checkSignUp(User user) throws SQLException {
		// TODO 查询用户信息是否重复
		ResultSet set;
		 PreparedStatement preStatement=conn.conn.prepareStatement("select * from [User] where account = ?");
		 preStatement.setString(1, user.getAccount());
		 set=preStatement.executeQuery();
        if(!set.next()){
        	
            return true;
        }
        else{
    		return false;
        }	
	}
	
	

	public boolean loginCheck(User user) throws SQLException{
		// TODO 验证登录
		ResultSet set;
	    PreparedStatement preStatement=conn.conn.prepareStatement("select * from [User] where account = ? and psw=?");
	    preStatement.setString(1, user.getAccount());
	    preStatement.setString(2, user.getPsw());
	    set=preStatement.executeQuery();
        if(!set.next()){
            return false;
        }
        else{
    		return true;
        }					
	}


	public void addUser(User user) {
		// TODO Auto-generated method stub
		 PreparedStatement preStatement;
		try {
			preStatement = conn.conn.prepareStatement("insert into  [User](account,psw,email,phoneNum,power,photo) values(?,?,?,?,?,?) ");
			 preStatement.setString(1, user.getAccount());
			 preStatement.setString(2, user.getPsw());
			 preStatement.setString(3, user.getEmail());
			 preStatement.setString(4, user.getPhoneNum());
			 preStatement.setBoolean(5, false);
			 preStatement.setString(6,"UploadImages/default.jpg");
			 preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}


	public void updateUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement preStatement;
		try{
			preStatement = conn.conn.prepareStatement("update [User] set psw = ? , email = ? , phoneNum = ? , power = ? , photo = ? where account = ?");
			preStatement.setString(1,user.getPsw());
			preStatement.setString(2,user.getEmail());
			preStatement.setString(3,user.getPhoneNum());
			preStatement.setBoolean(4,user.isPower());
			preStatement.setString(5,user.getPhoto());
			preStatement.setString(6,user.getAccount());
			preStatement.executeUpdate();
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
	}



	public User searchUser(String account) {
		// TODO Auto-generated method stub
		 ResultSet set;
		 PreparedStatement preStatement;
      	 User user=new User();
		try {
			preStatement = conn.conn.prepareStatement("select * from [User] where account = ?");
			preStatement.setString(1,account);
		    set=preStatement.executeQuery();
		    if(set.next()){
		       	  user.setAccount(account);
		       	  user.setPsw(set.getString("psw"));
		       	  user.setEmail(set.getString("email"));
		       	  user.setPhoneNum(set.getString("phoneNum"));
		       	  user.setPower(set.getBoolean("power"));
		       	  user.setPhoto(set.getString("photo"));
		       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return user;
		
	}

}
