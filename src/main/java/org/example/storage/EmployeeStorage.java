package org.example.storage;

import org.example.DAO;
import org.example.EntityRepository;
import org.example.ResultSetProcessor;
import org.example.SQLBuilder;
import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage implements Storage<Employee, Long> {
    private static  String url = "jdbc:postgresql://localhost:5432/Panelka";
    private static  String username = "postgres";
    private static  String password = "admin";

    private static Connection connection;

    private EntityRepository entityRepository;
    private DAO dao;

    public EmployeeStorage() {
        DAO.setCredentials(url, username, password);
        this.dao = DAO.getInstance();
        this.entityRepository = new EntityRepository(dao);
    }

    public Employee save(Employee entity) {
        String sql = SQLBuilder.buildInsert(entity, Employee.class);
        dao.executeUpdate(sql, entity, Employee.class);

//        String sql = "insert into employers(general_info, experience, skills, education, about, spec) values(?, ?, ?, ?, ?, ?)";
//        dao.executeUpdate(sql, statement -> {
//            statement.setString(1, entity.getGeneralInfo());
//            statement.setString(2, entity.getExperience());
//            statement.setString(3, entity.getSkills());
//            statement.setString(4, entity.getEducation());
//            statement.setString(5, entity.getAbout());
//            statement.setString(6, entity.getSpec());
//        });

        return entity;
    }

    public List<Employee> getAll(){
        return entityRepository.findAll(Employee.class);
    }
}
