package com.dao.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CategoryBean;
import com.helper.ConnectionUtils;
import com.mysql.jdbc.Statement;

public class CategoryDao {
	public static final String ALL_CATEGORIES="select * from Category";
	public List<CategoryBean> getAllCategories(){
		List<CategoryBean> ls=new ArrayList<>();
		try(Connection connection = ConnectionUtils.getConnection()){
			Statement ppstm=(Statement) connection.createStatement();
			
			ResultSet rs=ppstm.executeQuery(ALL_CATEGORIES);
			
			
			while(rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));

				ls.add(category);
				
			}
			 			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ls;	
	}
}
