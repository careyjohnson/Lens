package com.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.entity.Category;
import com.helper.ConnectionUtils;


public class ManagerCategoryDao {
	public static final String ALL_CATEGORIES="select * from Category;";
	public static final String ADD_CATEGORIES="insert Category values(?,?,?);";
	public static final String EDIT_CATEGORIES="update Category set id=?,name=?,description=?;";
	public static final String DELETE_CATEGORIES="delete from Category where id=?;";
	
	public List<Category> getListCategory() {

		List<Category> list = new ArrayList<>();
		try (Connection connection = ConnectionUtils.getConnection()){

			PreparedStatement preparedStatement = connection.prepareStatement(ALL_CATEGORIES);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				list.add(new Category(rs.getInt(1),
						rs.getString(2),
						rs.getString(3)));				
			}
			rs.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	public void addCategory(Category cb) {

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
	public void editCategory(Category cb) {

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
	
	public void removeCategory(Category cb) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(DELETE_CATEGORIES);
			sta.setInt(1, cb.getId());
			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
