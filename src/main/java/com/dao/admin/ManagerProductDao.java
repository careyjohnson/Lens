package com.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;
import com.helper.ConnectionUtils;


public class ManagerProductDao {
	private static final String SELECT_ALL_PRODUCT = "select id,name,description,price from Products;";
	private static final String ADD_PRODUCT = "insert Products (name,price,description) values(?,?,?);";
	private static final String EDIT_PRODUCT = "update Products set name=?, description=?, price=? where id=?;";
	private static final String DELETE_PRODUCT = "delete from Products where id=?;";
//	public ManagerProductDao() {
//		
//	}
	public List<Product> getListProduct() {

		List<Product> list = new ArrayList<>();
		try (Connection connection = ConnectionUtils.getConnection()){

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getDouble(4)));
						
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
	
	public void addProduct(Product pd) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(ADD_PRODUCT);
			sta.setInt(1, pd.getId());
			sta.setString(2, pd.getName());
			sta.setDouble(3, pd.getPrice());
			sta.setString(4, pd.getDescription());
			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void editProduct(Product pd) {

		try (Connection connection = ConnectionUtils.getConnection()){
			
			PreparedStatement sta = connection.prepareStatement(EDIT_PRODUCT);
			sta.setInt(1, pd.getId());
			sta.setString(2, pd.getName());
			sta.setDouble(3, pd.getPrice());
			sta.setString(4, pd.getDescription());
			
			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeProduct(Product pd) {

		try (Connection connection = ConnectionUtils.getConnection()){
			PreparedStatement sta = connection.prepareStatement(DELETE_PRODUCT);
			sta.setInt(1, pd.getId());
			int rs = sta.executeUpdate();
			sta.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	

	

}
