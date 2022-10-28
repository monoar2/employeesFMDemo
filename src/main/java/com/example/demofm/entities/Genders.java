package com.example.demofm.entities;

import javax.persistence.*;

@Entity
public class Genders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    public Genders() {
    }

    public Genders(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
