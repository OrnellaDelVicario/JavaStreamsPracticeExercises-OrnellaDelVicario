package com.company.bonus;

import java.util.List;

class Employee {
    private String name;
    private String department;
    private List<Project> projects;

    public Employee(String name, String department, List<Project> projects) {
        this.name = name;
        this.department = department;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
