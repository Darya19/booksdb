package com.epam.day8.builder;

import com.epam.day8.model.entity.Book;

public class BookBuilder {

    public Book buildBook(String title, String[] authors, double price, int pages) {
        return new Book(title, authors, price, pages);
    }
}
