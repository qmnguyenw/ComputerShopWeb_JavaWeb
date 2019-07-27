/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Quang Nguyen
 */
public class ProductDAO {
    
    Connection connection;

    public ProductDAO() throws Exception {
        try {
            connection = new DBContext().getConnection();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<Product> getAllProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM [products]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //add all record to list
            while (rs.next()) {
                productList.add(new Product(rs.getInt("id"), rs.getString("name"), 
                        rs.getInt("cat_ID"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getString("describe"), rs.getDate("adddate")));
            }
            return productList;
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void addProduct(int ID, String Name, int CategoryID, double Price, 
            int Quantity, String Describe, String addDate) throws Exception {
        try {
            PreparedStatement st1 = connection.prepareStatement("INSERT INTO [products]"
                    + " VALUES(?,?,?,?,?)");
            st1.setInt(1, ID);
            st1.setString(2, Name);
            st1.setInt(3, CategoryID);
            st1.setDouble(4, Price);
            st1.setInt(5, Quantity);
            st1.setString(6, Describe);
            Date addDateStr = new SimpleDateFormat("dd/MM/yyyy").parse(addDate);
            st1.setDate(7, (java.sql.Date) addDateStr);
            st1.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void removeProduct(int ID) throws Exception {
        try {
            PreparedStatement st1 = connection.prepareStatement("DELETE FROM [products]"
                    + " WHERE [id] = ?");
            st1.setInt(1, ID);
            st1.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public Product getProductByID(int ID) throws Exception {
        String sql = "SELECT * from [products] WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ID);//should add "" because int ID
            ResultSet rs = st.executeQuery();
            //get reader
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), 
                        rs.getInt("cat_ID"), rs.getDouble("price"), rs.getInt("quantity"),
                        rs.getString("describe"), rs.getDate("adddate"));
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Category getCategoryByID(int ID) throws SQLException {
        String sql = "select * from [categories] where [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ID+"");
            ResultSet rs = st.executeQuery();
            //get category
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<Category> getAllCategories() throws Exception {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM [categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //add all record to list
            while (rs.next()) {
                categoryList.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe")));
            }
            return categoryList;
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public Category getCategoryByProductID(int ID) throws Exception {
        String sql = "select c.*\n" +
                    "from products d inner join categories c\n" +
                    "on d.cat_ID = c.id\n" +
                    "where d.id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ID);
            ResultSet rs = st.executeQuery();
            //get list of categories
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void updateProduct(int ID, String Name, int CategoryID, double Price, 
            int Quantity, String Describe, String addDate) throws Exception {
        String sql = "UPDATE [products]\n" +
                    "SET [name] = ?, [cat_ID] = ?, [price] = ?, [quantity] = ?,\n" +
                    "[describe] = ?, [adddate] = ?\n" +
                    "WHERE [id] = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(7, ID);
            st.setString(1, Name);
            st.setInt(2, CategoryID);
            st.setDouble(3, Price);
            st.setInt(4, Quantity);
            st.setString(5, Describe);
            Date addDateStr = new SimpleDateFormat("dd/MM/yyyy").parse(addDate);
            st.setDate(6, (java.sql.Date) addDateStr);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}
