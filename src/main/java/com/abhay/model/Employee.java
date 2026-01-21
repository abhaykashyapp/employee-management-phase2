package com.abhay.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private String name;
    private double salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id,String name,double salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
