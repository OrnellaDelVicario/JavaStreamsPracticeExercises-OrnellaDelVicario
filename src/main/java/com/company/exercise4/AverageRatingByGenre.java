package com.company.exercise4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageRatingByGenre {

    public static Map<String, Double> averageRating (List<Movie> movies){
        return movies.stream()
                .collect(Collectors.groupingBy(
                 Movie::getGenre,
                        Collectors.averagingDouble(Movie::getRating)
                ));
    }

    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("Inception", "Sci-Fi", 8.8),
                new Movie("The Matrix", "Sci-Fi", 8.7),
                new Movie("Titanic", "Drama", 7.8),
                new Movie("The Godfather", "Drama", 9.2),
                new Movie("Shrek", "Comedy", 7.9)
        );

        Map<String, Double> averageByGenre = averageRating(movies);
        averageByGenre.forEach((genre, avg) ->
                System.out.printf("%s: %.2f%n", genre, avg));
    }
}
