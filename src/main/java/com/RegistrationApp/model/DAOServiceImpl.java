package com.RegistrationApp.model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
	
	private Connection con;
	
	private Statement stmt;

	@Override
	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_db_app","root","7872");
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		}

	@Override
	public boolean verifylogin(String email, String password) {
		try {
			ResultSet result = stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveregister(String name, String city, String email, String mobile) {
		try {
			stmt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"') ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ResultSet readAllReg() {
		try {
			ResultSet result = stmt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void delete(String email) {
		try {
			stmt.executeUpdate("delete from registration where email = '"+email+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateRegistration(String email, String mobile) {
		try {
			stmt.executeUpdate("update registration set mobile ='"+mobile+"' where email = '"+email+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
