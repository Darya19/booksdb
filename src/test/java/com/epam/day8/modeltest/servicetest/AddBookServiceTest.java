package com.epam.day8.modeltest.servicetest;

import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.service.BookService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class AddBookServiceTest {

    BookService service;

    @BeforeClass
    public void setUp() {
        service = new BookService();
    }

    @Test
    public void addBookPositiveTest() {
        try {
            int actual = service.addBook("Harry Potter and the chamber of secrets",
                    new String[]{"J.K. Rowling"}, "942.38", "615");
            int expected = 1;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeAuthorValidationTest() throws BookServiceException {
        service.addBook("Harry Potter and the chamber of secrets",
                new String[0], "942.38", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeTitleValidationTest() throws BookServiceException {
        service.addBook("Ha", new String[]{"J.K. Rowling"}, "942.38", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePriceValidationTest() throws BookServiceException {
        service.addBook("Harry Potter and the chamber of secrets",
                new String[]{"J.K. Rowling"}, "-85", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePagesValidationTest() throws BookServiceException {
        service.addBook("Harry Potter and the chamber of secrets",
                new String[]{"J.K. Rowling"}, "942.58", "0");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePagesParsingTest() throws BookServiceException {
        service.addBook("Harry Potter and the chamber of secrets",
                new String[]{"J.K. Rowling"}, "942.58", "jhhhvj");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePriceParsingTest() throws BookServiceException {
        service.addBook("Harry Potter and the chamber of secrets",
                new String[]{"J.K. Rowling"}, "bghj", "458");
    }
}
