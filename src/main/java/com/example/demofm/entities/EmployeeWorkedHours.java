package com.example.demofm.entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class EmployeeWorkedHours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employees_id", nullable = false)
    private Employees employees;
    @Column
    private int workedHours;
    @Column
    private Date workedDate;

    public EmployeeWorkedHours() {
    }

    public EmployeeWorkedHours(int id, Employees employees, int workedHours, Date workedDate) {
        this.id = id;
        this.employees = employees;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public Date getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(Date workedDate) {
        this.workedDate = workedDate;
    }

    @Override
    public String toString() {
        return "EmployeeWorkedHours{" +
                "id=" + id +
                ", employees=" + employees +
                ", workedHours=" + workedHours +
                ", workedDate=" + workedDate +
                '}';
    }
}
