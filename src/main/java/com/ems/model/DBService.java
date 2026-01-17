package com.ems.model;

import java.sql.ResultSet;

public interface DBService {
	
	public void connectDB();
	
	public boolean verifyLogin(String email ,String password);
	
	public int getUserByEmail(String email);
	
	public void saveRegistration(String name, String course, String email, String mobile, int userId);

	public ResultSet getRegistrationByUserId(int userId);
	
	public void deleteRegistrationById(int id);
	
	public ResultSet getRegistrationById(int id);
	
	public String updateRegistrationData(int id, String name, String course, String email, String mobile, int userId);
}
