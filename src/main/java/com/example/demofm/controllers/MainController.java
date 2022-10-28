package com.example.demofm.controllers;

import com.example.demofm.entities.EmployeeWorkedHours;
import com.example.demofm.entities.Employees;
import com.example.demofm.services.EWHService;
import com.example.demofm.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class MainController {

    private static ObjectMapper objectMapper;
    private static EmployeeService employeeService;
    private static EWHService ewhService;

    @PostMapping(value = "/employees/add")
    @ResponseBody
    private static ResponseEntity<String> addEmployee(@RequestParam String request) throws JsonProcessingException {
        Boolean response = false;
        Employees employee = objectMapper.readValue(request, Employees.class);

        if(Period.between(employee.getBirthdate().toLocalDate(), LocalDate.now()).getYears() < 18){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        if(!ewhService.existsById(employee.getJobId().getId())){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        if(employeeService.findByNameAndLastName(employee.getName(), employee.getLastName())){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        try{
            employeeService.save(employee);
            response = true;
            return new ResponseEntity<>("id: "+employee.getId()+", success:"+response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employees")
    private static ResponseEntity<String> getEmployees(@RequestParam(name = "job_id") int jobId){
        Boolean response = false;
        try{
            ArrayList<Employees> employees = (ArrayList<Employees>) employeeService.findAll();
            Map<String, List<Employees>> resultSet = employeeService.filterEmployees(employees,jobId);
            response = true;
            return new ResponseEntity<>(resultSet.toString() + " ,success:"+response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/employees/details")
    private static ResponseEntity<String> getEmployeesDetails(@RequestParam("employee_id") int[] employeeIDs){
        Boolean response = false;
        try{
            ArrayList<Employees> employees = (ArrayList<Employees>) employeeService.getEmployeesById(employeeIDs);
            response = true;
            return new ResponseEntity<>(employees.toString()+", success:"+response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employees/hours")
    private static ResponseEntity<String> getEmployeeHours(@RequestParam("employee_id") int employeeId, @RequestParam("start_date") Date startDate, @RequestParam("end_date") Date endDate){
        Boolean response = false;
        long twh = 0;
        if(!employeeService.findById(employeeId).isPresent()){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        if(startDate.after(endDate)){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        try{
            twh = ewhService.getTotalWorkingHoursByEmploye(employeeId,startDate,endDate);
            return new ResponseEntity<>( "total_worked_hours: " + twh + " ,success:"+response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employees/salary")
    private static ResponseEntity<String> getEmployeeSalary(@RequestParam("employee_id") int employeeId, @RequestParam("start_date") Date startDate, @RequestParam("end_date") Date endDate){
        Boolean response = false;
        long twh = 0;
        BigDecimal salary = BigDecimal.valueOf(0);
        if(!employeeService.findById(employeeId).isPresent()){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        if(startDate.after(endDate)){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.BAD_REQUEST);
        }
        try{
            twh = ewhService.getTotalWorkingHoursByEmploye(employeeId,startDate,endDate);
            salary = employeeService.getReferenceById(employeeId).getJobId().getSalary();
            return new ResponseEntity<>( "payment: " + salary.multiply(BigDecimal.valueOf(twh)) + " ,success:"+response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("id: null, success:"+response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
