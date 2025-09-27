package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String  Name;
    private String
                 Salary;

    public Student() {
    }

    public Student(Long id, String name, String salary) {
        Id = id;
        Name = name;
        Salary = salary;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
