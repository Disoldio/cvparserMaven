package org.example.storage;

import org.example.ResultSetProcessor;
import org.example.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeResultSetProcessor implements ResultSetProcessor<Employee> {

    @Override
    public List<Employee> process(ResultSet resultSet) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            while(resultSet.next()){

                Employee employee = new Employee();
                employee.setGeneralInfo(resultSet.getString("general_info"));
                employee.setExperience(resultSet.getString("experience"));
                employee.setSkills(resultSet.getString("skills"));
                employee.setEducation(resultSet.getString("education"));
                employee.setAbout(resultSet.getString("about"));
                employee.setSpec(resultSet.getString("spec"));

                employeeList.add(employee);

            }
        }catch (SQLException e){

        }

        return employeeList;
    }
}
