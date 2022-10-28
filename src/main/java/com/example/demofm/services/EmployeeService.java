package com.example.demofm.services;

import com.example.demofm.entities.Employees;
import com.example.demofm.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;


@Service
public interface EmployeeService extends EmployeeInterface{

    default Map<String, List<Employees>> filterEmployees(ArrayList<Employees> employees, int jobId){
        Map<String, List<Employees>> resultSet =
                employees.stream().filter(e -> e.checkJobId(jobId))
                        .sorted(Comparator.comparing(Employees::getLastName))
                        .collect(Collectors.groupingBy(Employees::getLastName));
        return resultSet;
    }

    default List<Employees> getEmployeesById(int[] employeeIDs) throws ExecutionException, InterruptedException {
        ArrayList<Employees> resultSet = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Employees> employeesFuture = null;
        for (int employeeID : employeeIDs) {
            employeesFuture = executorService.submit(() ->
                 getReferenceById(employeeID)
            );
        }
        assert employeesFuture != null;
        resultSet.add(employeesFuture.get());
        return resultSet;
    }

}
