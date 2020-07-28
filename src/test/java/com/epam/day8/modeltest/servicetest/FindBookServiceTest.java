package com.epam.day8.modeltest.servicetest;

import com.epam.day8.controllertest.StaticDataProvider;
import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.entity.Book;
import com.epam.day8.model.service.BookService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class FindBookServiceTest {

    BookService service;

    @BeforeClass
    public void setUp() {
        service = new BookService();
    }

    @Test
    public void FindByIdPositiveTest() {
        try {
            List<Book> actual = service.findById("5");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByIdNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findById("234");
            assertEquals(actual, new ArrayList<>());
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(dataProvider = "all books", dataProviderClass = StaticDataProvider.class)
    public void FindByIdNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = service.findById();
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByIdNegativeParsingTest() throws BookServiceException {
        service.findById("hgfj", "456");
    }

    @Test
    public void FindByTitlePositiveTest() {
        try {
            List<Book> actual = service.findByTitle("Ralph Johnson: Complete Works");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(5, "Ralph Johnson: Complete Works",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByTitleNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findByTitle("Ralph Johnson");
            assertEquals(new ArrayList<>(), actual);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by title archive", dataProviderClass = StaticDataProvider.class)
    public void FindByTitleNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = service.findByTitle();
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByAuthorsPositiveTest() {
        try {
            List<Book> actual = service.findByAuthor("Ralph Johnson");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                    new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByAuthorNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findByAuthor("46nbjb");
            assertEquals(actual, new ArrayList<>());
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by authors archive", dataProviderClass = StaticDataProvider.class)
    public void FindByAuthorNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = service.findByAuthor();
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByPricePositiveTest() {
        try {
            List<Book> actual = service.findByPrice("200", "300");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
            expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                    new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByPriceNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findByPrice("56.036", "99.999");
            assertEquals(actual, new ArrayList<>());
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByPriceNegativeParsingTest() throws BookServiceException {
        service.findByPrice("hgh");
    }

    @Test(dataProvider = "sorted by price archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPriceNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = service.findByPrice();
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByPagesPositiveTest() {
        try {
            List<Book> actual = service.findByPages("400", "500");
            List<Book> expected = new ArrayList<>();
            expected.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
            expected.add(new Book(5, "Ralph Johnson: Complete Work",
                    new String[]{"Ralph Johnson"}, 236.99, 448));
            assertEquals(expected, actual);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByPagesNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findByPages("0", "99");
            assertEquals(actual, new ArrayList<>());
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(dataProvider = "sorted by pages archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPagesNotInputDataPositiveTest(List<Book> expected) {
        try {
            List<Book> actual = service.findByPrice();
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByPagesCommandNegativeParsingTest() throws BookServiceException {
        service.findByPages("ghk");
    }
}
