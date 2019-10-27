package com.example.lenovo.familyexpence;

public class Employee {
    private int employeeId;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
    }


    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
