/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quang Nguyen
 */
public class AccountDAO {
    private Connection connection;

    public AccountDAO(DBContext dbContext) throws Exception{
        try {
            connection = dbContext.getConnection();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Account getAccountByUsername(String username) throws Exception {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM [account] "
                            + "WHERE [username] = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                return account;
            }
        }catch (SQLException ex) {
            throw ex;
        }
        return null;
    }
}
