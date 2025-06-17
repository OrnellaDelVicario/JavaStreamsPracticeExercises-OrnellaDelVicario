package com.company.bonus;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Ana", "IT", List.of(
                        new Project("active", 2000),
                        new Project("completed", 1500)
                )),
                new Employee("Ben", "IT", List.of(
                        new Project("completed", 1800)
                )),
                new Employee("Carla", "HR", List.of(
                        new Project("active", 1000),
                        new Project("completed", 1200)
                ))
        );

        // 🔹 1. Count Active projects per department
        Map<String, Long> activeProjectsPerDept = employees.stream()
                .flatMap(emp -> emp.getProjects().stream()
                        .filter(p -> p.getStatus().equalsIgnoreCase("active"))
                        .map(p -> emp.getDepartment()))
                .collect(Collectors.groupingBy(dept -> dept, Collectors.counting()));

        System.out.println("Active projects per department:");
        activeProjectsPerDept.forEach((dept, count) ->
                System.out.println(dept + ": " + count));

        // 🔹 2. Average budget of completed projects per department
        Map<String, Double> avgBudgetCompletedProjects = employees.stream()
                .flatMap(emp -> emp.getProjects().stream()
                        .filter(p -> p.getStatus().equalsIgnoreCase("completed"))
                        .map(p -> new AbstractMap.SimpleEntry<>(emp.getDepartment(), p.getBudget())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                ));

        System.out.println("\nAverage budget of completed projects per department:");
        avgBudgetCompletedProjects.forEach((dept, avgBudget) ->
                System.out.printf("%s: $%.2f%n", dept, avgBudget));
    }
}
