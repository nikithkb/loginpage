package com.blueyonder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blueyonder.model.User;
import com.blueyonder.service.DBConnectionUtil;
import com.blueyonder.service.QueryMapper;

public class LoginAppImpl implements LoginApp {

    @Override
    public User confirmUser(String username, String password) {
        // User user = new User();
        Connection conn = DBConnectionUtil.getDBConnection();
        try {
            PreparedStatement pStmt = conn.prepareStatement(QueryMapper.CHECK_LOGIN);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                boolean isAdmin = rs.getBoolean("admin");
                if (isAdmin) {
                    returnNonAdminUsers();
                } else {
                    System.out.println("Hello " + rs.getString("username"));
                }
            } else {
                System.out.println("Username or password is incorrect");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User returnNonAdminUsers() {
        Connection conn = DBConnectionUtil.getDBConnection();
        try {
            PreparedStatement pStmt = conn.prepareStatement(QueryMapper.NON_ADMIN);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                System.out.println("List of non-admins:");
                System.out.println(rs.getString("username"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
