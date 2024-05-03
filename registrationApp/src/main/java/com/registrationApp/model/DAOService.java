package com.registrationApp.model;

import java.sql.*;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String name, String password);
	public boolean saveRegistration(String name, String city,String email,String mobile);
	public ResultSet readAllReg();
	public void deleteByEmail(String email);
}
