package com.company.exercise6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlattenAuthorBooksPages {
    public static void main(String[] args) {

        // Author 1: Alice Munro - 2 books
        Author munro = new Author("Alice Munro", List.of(
                new Book("Dear Life", List.of("The Bear Came Over the Mountain", "Gravel")),
                new Book("Runaway", List.of("Chance", "Silent Snow, Secret Snow"))
        ));

        // Author 2: Bob (Fictitious Author) - 2 books
        Author bob = new Author("Bob Smith", List.of(
                new Book("Mystery in the Woods", List.of("The Missing Key", "The Hidden Path")),
                new Book("Shadows in the Fog", List.of("The Storm", "Lost Souls"))
        ));

        // Author 3: Margaret Atwood - 2 books
        Author atwood = new Author("Margaret Atwood", List.of(
                new Book("The Handmaid's Tale", List.of("Offred", "The Ceremony")),
                new Book("Oryx and Crake", List.of("The Year of the Flood", "The End of the World"))
        ));

        // List of authors
        List<Author> authors = List.of(munro, bob, atwood);

        // ✅ Flatten Author → Books → Chapters (Titles)
        List<String> allChapters = authors.stream()
                .flatMap(author -> author.getBooks().stream())     // Author → Book
                .flatMap(book -> book.getPages().stream())      // Book → Chapter (Title)
                .collect(Collectors.toList());                     // Collect flat list

        // Print every chapter(pages)
        System.out.println("\nThis is a list of every page (title of a book's chapter) for every Book by every Author: \n");
        allChapters.forEach(System.out::println);

        // Group Pages by Author
        Map<String, List<String>> chaptersByAuthor = authors.stream()
                .collect(Collectors.toMap(
                        Author::getName,  // Key: author's name
                        author -> author.getBooks().stream()
                                .flatMap(book -> book.getPages().stream())
                                .collect(Collectors.toList())
                ));

        // Print pages grouped by Author
        System.out.println("\n And here we can see every Page grouped by Author: \n");

             chaptersByAuthor.forEach((author, chapters) -> {
             System.out.println(author + " has written:");
             chapters.forEach(System.out::println);
             System.out.println("\n");
        });

    }
}

