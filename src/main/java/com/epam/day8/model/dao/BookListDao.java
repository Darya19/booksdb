package com.epam.day8.model.dao;

import com.epam.day8.exception.BookDaoException;
import com.epam.day8.model.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookListDao {

    int addBook(Book book) throws BookDaoException;

    int removeBook(Book book) throws BookDaoException;

    List<Book> findById(int... id) throws BookDaoException;

    List<Book> findByTitle(String... title) throws BookDaoException;

    List<Book> findByAuthor(String... author) throws BookDaoException;

    List<Book> findByPrice(double... price) throws BookDaoException;

    List<Book> findByPages(int... pages) throws BookDaoException;

    List<Book> getAllBooks() throws BookDaoException, SQLException;
}
