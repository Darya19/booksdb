package com.epam.day8.modeltest.servicetest;

import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.service.BookService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class RemoveBookServiceTest {
    BookService service;

    @BeforeClass
    public void setUp() {
        service = new BookService();
    }

    @Test
    public void removeBookPositiveTest() {
        try {
            int actual = service.removeBook("Winnie-the-Pooh",
                    new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "458.96", "194");
            int expected = 1;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeAuthorValidationTest() throws BookServiceException {
        service.removeBook("Winnie-the-Pooh",
                new String[0], "458.96", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeTitleValidationTest() throws BookServiceException {
        service.removeBook("Wi",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "458.96", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePriceValidationTest() throws BookServiceException {
        service.removeBook("Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "-966", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePagesValidationTest() throws BookServiceException {
        service.removeBook("Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "458.96", "5000");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePagesParsingTest() throws BookServiceException {
        service.removeBook("Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "458.96", "lkjljo");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePriceParsingTest() throws BookServiceException {
        service.removeBook("Winnie-the-Pooh",
                new String[]{"Alan Alexander Milne", "P.G.Wodehouse"}, "xfbd", "194");
    }
}
