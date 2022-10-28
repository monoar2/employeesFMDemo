package com.example.demofm.services;

import com.example.demofm.entities.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface EHWInterface extends JpaRepository<EmployeeWorkedHours, Integer> {
    @Query(nativeQuery = true, value = "SELECT SUM (WORKED_HOURS) FROM EMPLOYEE_WORKED_HOURS WHERE  EMPLOYEE_ID = :employeeId AND WORKED_DATE BETWEEN :startDate and :endDate")
    long getTotalWorkingHoursByEmploye(int employeeId, Date startDate, Date endDate);
}
