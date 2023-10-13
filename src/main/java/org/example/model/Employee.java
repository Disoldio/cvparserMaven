package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Column;
import org.example.Entity;
import org.example.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(tableName = "employers")
public class Employee {

    @Column(columnName = "general_info")
    private String generalInfo;

    @Column(columnName = "spec")
    private String spec;

    @Column(columnName = "experience")
    private String experience;

    @Column(columnName = "skills")
    private String skills;

    @Column(columnName = "education")
    private String education;

    @Column(columnName = "about")
    private String about;

}
