package com.company.exercise7;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEventsByDay {
    public static void main(String[] args) {
        List<Event> events = List.of(
                new Event("Conference", LocalDate.of(2025, 6, 17)), // Tuesday
                new Event("Workshop", LocalDate.of(2025, 6, 18)),   // Wednesday
                new Event("Meetup", LocalDate.of(2025, 6, 17)),     // Tuesday
                new Event("Webinar", LocalDate.of(2025, 6, 19))     // Thursday
        );

        // Group by DayOfWeek
        Map<DayOfWeek, List<Event>> eventsByDay =
                events.stream()
                .collect(Collectors.groupingBy(event -> event.getDate().getDayOfWeek()));

        // Show results
        System.out.println("\nEvents grouped by Day of the Week:\n");
        eventsByDay.forEach((day, evts) -> {
            System.out.println(day + ":");
            evts.forEach(e -> System.out.println("  - " + e.getName()));
        });
    }
}