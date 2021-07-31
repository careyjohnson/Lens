package com.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CategoryBean;
import com.helper.ConnectionUtils;
import com.mysql.jdbc.Statement;

public class CategoryDao {
	public static final String ALL_CATEGORIES="select * from Category;";
	public static final String ADD_CATEGORIES="insert Category values(?,?,?);";
	public static final String EDIT_CATEGORIES="update Category set id=?,name=?,description=?;";
	public static final String DELETE_CATEGORIES="delete from Category where id=?;";
	public List<CategoryBean> getAllCategories(){
		List<CategoryBean> ls=new ArrayList<>();
		try(Connection connection = ConnectionUtils.getConnection()){
			Statement ppstm=(Statement) connection.createStatement();
			
			ResultSet rs=ppstm.executeQuery(ALL_CATEGORIES);
			
			
			while(rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));

				ls.add(category);
				
			}
			 			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ls;	
	}
	public void addCategory(CategoryBean cb) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(ADD_CATEGORIES);
			
			sta.setInt(1, cb.getId());
			sta.setString(2, cb.getName());
			sta.setString(3, cb.getDescription());

			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void editCategory(CategoryBean cb) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(EDIT_CATEGORIES);
			sta.setInt(1, cb.getId());
			sta.setString(2, cb.getName());
			sta.setString(3, cb.getDescription());

			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeCategory(CategoryBean cb) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(EDIT_CATEGORIES);
			sta.setInt(1, cb.getId());
			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
