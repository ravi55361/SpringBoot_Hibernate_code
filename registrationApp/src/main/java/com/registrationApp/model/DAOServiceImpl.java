package com.registrationApp.model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmt;


	@Override
	public void connectDB() {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg_db_app","root","test");
			stmt= con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet executeQuery = stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return executeQuery.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveRegistration(String name, String city, String email, String mobile) {
		try {
		    stmt.executeUpdate("insert into registration values ('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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

	public void deleteByEmail(String email) {
		try {
			stmt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void updateByEmailAndPhone(String email, String mobile) {
		try {
			stmt.executeUpdate("update registration set mobile ='"+mobile+"' where email='"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
}
