package com.epam.day8.modeltest.daotest;

import com.epam.day8.controllertest.StaticDataProvider;
import com.epam.day8.exception.BookDaoException;
import com.epam.day8.model.dao.impl.BookListDaoImpl;
import com.epam.day8.model.entity.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BookListDaoTest {

    BookListDaoImpl dao;

    @BeforeClass
    public void setUp() {
        dao = new BookListDaoImpl();
    }

    @Test
    public void addBookPositiveTest() {
        Book book = new Book("Harry Potter and the chamber of secrets",
                new String[]{"J.K. Rowling"}, 942.38, 615);
        try {
            int actual = dao.addBook(book);
            int expected = 1;
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void removeBookPositiveTest() {
        Book book = new Book(2, "Harry Potter and the Philosopher’s Stone",
                new String[]{"J.K. Rowling"}, 780.8, 219);
        try {
            int actual = dao.removeBook(book);
            int expected = 1;
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByIdPositiveTest() {
        try {
            List<Book> actual = dao.findById(5);
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByIdNotFoundPositiveTest() {
        try {
            List<Book> actual = dao.findById(0);
            assertEquals(actual, new ArrayList<>());
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(dataProvider = "all books", dataProviderClass = StaticDataProvider.class)
    public void FindByIdNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = dao.findById();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByTitlePositiveTest() {
        try {
            List<Book> actual = dao.findByTitle("Ralph Johnson: Complete Work");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByTitleNotFoundPositiveTest() {
        try {
            List<Book> actual = dao.findByTitle("Ralph");
            List<Book> expected = new ArrayList<>();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by title archive", dataProviderClass = StaticDataProvider.class)
    public void FindByTitleNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = dao.findByTitle();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByAuthorsPositiveTest() {
        try {
            List<Book> actual = dao.findByAuthor("Ralph Johnson");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                    new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
            expected.add(new Book(5, "Ralph Johnson: Complete Work", new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(expected, actual);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByAuthorNotFoundPositiveTest() {
        try {
            List<Book> actual = dao.findByAuthor("jggk");
            List<Book> expected = new ArrayList<>();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by authors archive", dataProviderClass = StaticDataProvider.class)
    public void FindByAuthorNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = dao.findByAuthor();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByPricePositiveTest() {
        try {
            List<Book> actual = dao.findByPrice(236.95, 237);
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                    new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
            expected.add(new Book(5, "Ralph Johnson: Complete Work", new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(expected, actual);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByPriceNotFoundPositiveTest() {
        try {
            List<Book> actual = dao.findByPrice(1, 10);
            List<Book> expected = new ArrayList<>();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by price archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPriceNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = dao.findByPrice();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByPagesPositiveTest() {
        try {
            List<Book> actual = dao.findByPages(440, 450);
            List<Book> expected = new ArrayList<>();
            List<String> authors = new ArrayList<>();
            authors.add("Ralph Johnson");
            expected.add(new Book(5, "Ralph Johnson: Complete Work", new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(expected, actual);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByPagesNotFoundPositiveTest() {
        try {
            List<Book> actual = dao.findByPages(1, 10);
            List<Book> expected = new ArrayList<>();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by pages archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPagesNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = dao.findByPages();
            assertEquals(actual, expected);
        } catch (BookDaoException e) {
            fail();
        }
    }
}
