package com.company.exercise6;

import java.util.List;

public class Book {
    private String title;
    private List<String> pages;

    public Book(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getPages() {
        return pages;
    }
}