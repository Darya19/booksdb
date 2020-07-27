package com.epam.day8.model.service;

import com.epam.day8.builder.BookBuilder;
import com.epam.day8.exception.BookDaoException;
import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.dao.impl.BookListDaoImpl;
import com.epam.day8.model.entity.Book;
import com.epam.day8.parser.NumberParser;
import com.epam.day8.validator.BookValidator;

import java.util.List;

public class BookService {

    BookListDaoImpl dao = new BookListDaoImpl();

    public int addBook(String title, List<String> authors, String price, String pages) throws BookServiceException {
        NumberParser parser = new NumberParser();
        BookValidator validator = new BookValidator();
        BookBuilder builder = new BookBuilder();
        int intPages;
        double doublePrice;
        intPages = parser.parseToInt(pages);
        doublePrice = parser.parseToDouble(price);
        Book book = builder.buildBook(title, authors, doublePrice, intPages);
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                return dao.addBook(book);
            } catch (BookDaoException e) {
                throw new BookServiceException("impossible add book", e);
            }
        } else {
            throw new BookServiceException("invalid input data");
        }
    }

    public int removeBook(String title, List<String> authors, String price, String pages) throws BookServiceException {
        NumberParser parser = new NumberParser();
        BookValidator validator = new BookValidator();
        BookBuilder builder = new BookBuilder();
        int intPages;
        double doublePrice;
        intPages = parser.parseToInt(pages);
        doublePrice = parser.parseToDouble(price);
        Book book = builder.buildBook(title, authors, doublePrice, intPages);
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                return dao.removeBook(book);
            } catch (BookDaoException e) {
                throw new BookServiceException("impossible remove book", e);
            }
        } else {
            throw new BookServiceException("invalid input data");
        }
    }

    public List<Book> findById(String... id) throws BookServiceException {
        int[] intId = null;
        if (id.length != 0) {
            NumberParser parser = new NumberParser();
            intId = parser.parseToIntMassive(id);
        }
        try {
            List<Book> foundBooks = dao.findById(intId);
            return foundBooks;
        } catch (BookDaoException e) {
            throw new BookServiceException("impossible find any book by id");
        }
    }

    public List<Book> findByTitle(String... title) throws BookServiceException {
        try {
            List<Book> foundBooks = dao.findByTitle(title);
            return foundBooks;
        } catch (BookDaoException e) {
            throw new BookServiceException("impossible find any book by title");
        }
    }

    public List<Book> findByAuthor(String... author) throws BookServiceException {
        try {
            List<Book> foundBooks = dao.findByAuthor(author);
            return foundBooks;
        } catch (BookDaoException e) {
            throw new BookServiceException("impossible find any book by title");
        }
    }

    public List<Book> findByPrice(String... price) throws BookServiceException {
        double[] doublePrice = null;
        if (price.length != 0) {
            NumberParser parser = new NumberParser();
            doublePrice = parser.parseToDoubleMassive(price);
        }
        try {
            List<Book> foundBooks = dao.findByPrice(doublePrice);
            return foundBooks;
        } catch (BookDaoException e) {
            throw new BookServiceException("impossible find any book by price");
        }
    }

    public List<Book> findByPages(String... pages) throws BookServiceException {
        int[] intPages = null;
        if (pages.length != 0) {
            NumberParser parser = new NumberParser();
            intPages = parser.parseToIntMassive(pages);
        }
        try {
            List<Book> foundBooks = dao.findByPages(intPages);
            return foundBooks;
        } catch (BookDaoException e) {
            throw new BookServiceException("impossible find any book by pages");
        }
    }
}


