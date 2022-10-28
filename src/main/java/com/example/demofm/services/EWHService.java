package com.example.demofm.services;

import com.example.demofm.entities.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EWHService extends EHWInterface{

    public default long totalWorkedHoursPerEmployee(){
        long result = 0;

        return result;
    }
}