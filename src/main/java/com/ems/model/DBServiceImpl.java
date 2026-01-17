package com.ems.model;

import java.sql.*;


public class DBServiceImpl implements DBService {

	private Connection con;
	private Statement stmt;
	@Override
	public void connectDB() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");


			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsdb","root","Asif@123");
			 		
			 stmt = con.createStatement();
			
		}catch(Exception a) {
			a.printStackTrace();
		}

	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			
			ResultSet result = stmt.executeQuery("select * from user where email='"+email+"' and password='"+password+"'");
			
			return result.next();
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int getUserByEmail(String email) {
		try {
			ResultSet result = stmt.executeQuery("select * from user where email='"+email+"'");
			 if(result.next()) {
				 
				 int userId = result.getInt(1);
				 return userId;
			 }
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		return 0;
	}

	public void saveRegistration(String name, String course, String email, String mobile, int userId) {
		try {
			
			stmt.executeUpdate("INSERT INTO registration(name,course,email,mobile,user_id) VALUES('"+name+"','"+course+"','"+email+"','"+mobile+"','"+userId+"')");
			
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		
	}

	public ResultSet getRegistrationByUserId(int userId) {
		try {
			
			ResultSet result = stmt.executeQuery("select * from registration where user_id='"+userId+"'");
			
			//if(result.next()) 
				 
				 
			 return result;
			
			
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		return null;
	}

	public void deleteRegistrationById(int id) {
		
        try {
			
        	stmt.executeUpdate("Delete from registration where id='"+id+"'");

			
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		
		
	}

	public ResultSet getRegistrationById(int id) {
		
		try {
			
			ResultSet result = stmt.executeQuery("select * from registration where id='"+id+"' ");
			
			return result;
			
		} catch (Exception a) {
			a.printStackTrace();
		}
		return null;
	}

	


	public String updateRegistrationData(int id, String name, String course, String email, String mobile, int userId) {
	
		
		    try {
		        String query = "UPDATE registration "
		                     + "SET name = ?, course = ?, email = ?, mobile = ?, user_id = ? "
		                     + "WHERE id = ?";

		        PreparedStatement pstmt = con.prepareStatement(query); // assuming 'con' is your active Connection
		        pstmt.setString(1, name);
		        pstmt.setString(2, course);
		        pstmt.setString(3, email);
		        pstmt.setString(4, mobile);
		        pstmt.setInt(5, userId);
		        pstmt.setInt(6, id);

		        int rowsUpdated = pstmt.executeUpdate();
		        pstmt.close();
		        if (rowsUpdated > 0) {
		            return "✅ Registration record updated successfully for ID: " + id;
		        } else {
		            return "⚠️ No record found for ID: " + id;
		        }


		    } catch (Exception a) {
		        a.printStackTrace();
		    }
		
		return null;
	}
		
	}
	
