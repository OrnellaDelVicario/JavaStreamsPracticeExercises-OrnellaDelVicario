package com.company.bonus;

class Project {
    private String status;
    private double budget;

    public Project(String status, double budget) {
        this.status = status;
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public double getBudget() {
        return budget;
    }
}

