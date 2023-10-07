package org.example.storage;

import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage implements Storage<Employee, Long> {
    private static  String url = "jdbc:postgresql://localhost:5432/Panelka";
    private static  String username = "postgres";
    private static  String password = "admin";
    private static Connection connection;
    private DAO dao = DAO.getInstance();

    public EmployeeStorage() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Не удалось создать подключение к базе данных!");
        }
    }


    public Employee save(Employee entity) {
        String sql = "insert into employers(general_info, experience, skills, education, about, spec) values(?, ?, ?, ?, ?, ?)";
        dao.executeUpdate(sql, statement -> {
            statement.setString(1, entity.getGeneralInfo());
            statement.setString(2, entity.getExperience());
            statement.setString(3, entity.getSkills());
            statement.setString(4, entity.getEducation());
            statement.setString(5, entity.getAbout());
            statement.setString(6, entity.getSpec());
        });

        return entity;
    }


    public List<Employee> getAll(){
        String query = "select * from employers";
        List<Employee> listEmp = new ArrayList<>();

        try {
            ResultSet result = connection.createStatement().executeQuery(query);
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
