package com.example.demofm.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_id", nullable = false)
    private Genders genders;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Jobs jobs;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private Date birthdate;

    public Employees() {
    }

    public Employees(int id, Genders genders, Jobs jobs, String name, String lastName, Date birthdate) {
        this.id = id;
        this.genders = genders;
        this.jobs = jobs;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genders getGenderId() {
        return genders;
    }

    public void setGenderId(Genders genders) {
        this.genders = genders;
    }

    public Jobs getJobId() {
        return jobs;
    }

    public void setJobId(Jobs jobs) {
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean checkJobId(int jobId){
        return this.getJobId().getId() == jobId;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", genderId=" + genders.getId() +
                ", jobId=" + jobs.getId() +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
