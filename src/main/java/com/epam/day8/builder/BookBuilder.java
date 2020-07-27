package com.epam.day8.builder;

import com.epam.day8.model.entity.Book;

import java.util.List;

public class BookBuilder {

    public Book buildBook(String title, List<String> authors, double price, int pages) {
        return new Book(title, authors, price, pages);
    }
}
