package org.example.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO{
    private static  String url = "jdbc:postgresql://localhost:5432/Panelka";
    private static  String username = "postgres";
    private static  String password = "admin";
    private static DAO dao;
    private Connection connection;

    public static DAO getInstance(){
        if (dao == null){
            return new DAO();
        }
        return dao;
    }
    private DAO(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Don`t work");
        }
    }

    public Boolean executeUpdate(String sql, PreparedStatementFiller preparedStatementFiller){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatementFiller.fill(preparedStatement);

            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
