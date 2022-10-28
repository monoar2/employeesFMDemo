package com.example.demofm.services;

import com.example.demofm.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeInterface  extends JpaRepository<Employees, Integer> {

    boolean findByNameAndLastName(String Name, String LastName);

}