package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.helper.ConnectionUtils;
import com.mysql.jdbc.Statement;

public class StaffDao {
	public static final String ALL_STAFF="select * from Staff";
	public List<UserBean> getAllStaff(){
		try(Connection connection = ConnectionUtils.getConnection()){
			Statement ppstm=(Statement) connection.createStatement();
			
			ResultSet rs=ppstm.executeQuery(ALL_STAFF);
			List<UserBean> staffBeans=new ArrayList<>();
			
			while(rs.next()) {
				UserBean staff = new UserBean();
				staff.setId(rs.getInt("id"));
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setEmail(rs.getString("email"));
				staffBeans.add(staff);
			}
			
			return staffBeans;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
