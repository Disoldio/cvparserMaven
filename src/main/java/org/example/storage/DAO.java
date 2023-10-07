package org.example.storage;

import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Employee> getResult(String sql){
        List<Employee> listEmp = new ArrayList<>();

        try {
            ResultSet result = connection.createStatement().executeQuery(sql);

            while(result.next()){
                Employee emp = new Employee();
                emp.setGeneralInfo(result.getString("general_info"));
                emp.setExperience(result.getString("experience"));
                emp.setSkills(result.getString("skills"));
                emp.setEducation(result.getString("education"));
                emp.setAbout(result.getString("about"));
                emp.setSpec(result.getString("spec"));

                listEmp.add(emp);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listEmp;
    }
}
