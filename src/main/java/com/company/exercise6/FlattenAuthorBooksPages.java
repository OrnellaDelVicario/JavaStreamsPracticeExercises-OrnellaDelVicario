package com.company.exercise6;

import java.util.List;
import java.util.stream.Collectors;

public class FlattenAuthorBooksPages {
    public static void main(String[] args) {

        Book book1 = new Book("Book One", List.of("Page 1.1", "Page 1.2"));
        Book book2 = new Book("Book Two", List.of("Page 2.1"));
        Author author1 = new Author("Alice", List.of(book1));
        Author author2 = new Author("Bob", List.of(book2));

        List<Author> authors = List.of(author1, author2);

        // flatMap in 3 levels
        List<String> allPages = authors.stream()
                .flatMap(author -> author.getBooks().stream())           // Nivel 1: Author → Book
                .flatMap(book -> book.getPages().stream())               // Nivel 2: Book → Pages
                .collect(Collectors.toList());                           // Resultado plano

        allPages.forEach(System.out::println);
    }
}
