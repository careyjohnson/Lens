package com.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.bean.AdminLoginBean;
import com.helper.ConnectionUtils;

public class AdminLoginDao {
	public static final String IS_VALID_CREDENTIAL_ADMIN="select * from Staff where username=? and password=? and email=?;";
	public AdminBean isValidLoginAdmin(AdminLoginBean loginCredentialAdmin) {
		
		try(Connection connection = ConnectionUtils.getConnection()){
		
			PreparedStatement ppstm=connection.prepareStatement(IS_VALID_CREDENTIAL_ADMIN);
			ppstm.setString(1, loginCredentialAdmin.getUsername());
			ppstm.setString(2, loginCredentialAdmin.getPassword());
			ppstm.setString(3, loginCredentialAdmin.getEmail());
			
			ResultSet rs=ppstm.executeQuery();
			
			while(rs.next()){
				if(loginCredentialAdmin.getUsername().equals(rs.getString("username"))&&
						loginCredentialAdmin.getPassword().equals(rs.getString("password"))&&
						loginCredentialAdmin.getEmail().equals(rs.getString("email"))){

					AdminBean admin=new AdminBean();
					admin.setId(rs.getInt("id"));
					admin.setUsername(rs.getString("username"));
					admin.setPassword(rs.getString("password"));
					admin.setEmail(rs.getString("email"));
					return admin;
				}
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
