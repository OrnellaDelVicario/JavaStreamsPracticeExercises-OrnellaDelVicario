package com.company.exercise3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountTaskByStatus {

    public static Map<String, Long> countByStatus(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Fix bug", "In Progress"),
                new Task("Write tests", "Done"),
                new Task("Deploy", "To Do"),
                new Task("Refactor code", "In Progress"),
                new Task("Update docs", "Done")
        );

        Map<String, Long> counts = countByStatus(tasks);
        counts.forEach((status, count) -> System.out.println(status + ": " + count + ("")));

    }
}
