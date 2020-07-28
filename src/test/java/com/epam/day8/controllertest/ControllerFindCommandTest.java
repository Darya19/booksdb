package com.epam.day8.controllertest;

import com.epam.day8.controller.BookController;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;
import com.epam.day8.model.entity.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ControllerFindCommandTest {

    BookController controller;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
    }

    @Test
    public void FindByIdCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("id", new String[]{"5"});
        Response actual = controller.doGet("find", requestData);
        List<Book> foundBooks = new ArrayList<>();
        String[] authors = {"Ralph Johnson"};
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Work", new String[]{"Ralph Johnson"}, 236.99, 448));
        Response expected = ResponseHelper.makeOkResponse(foundBooks);
        assertEquals(actual, expected);
    }

    @Test
    public void FindByIdCommandNotFoundPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("id", new String[]{"217"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "all books", dataProviderClass = StaticDataProvider.class)
    public void FindByIdCommandNothingRequiredPositiveTest(List<Book> books) {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("id", new String[0]);
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(books);
        assertEquals(actual, expected);
    }

    @Test()
    public void findByIdCommandNegativeParsingTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("id", new String[]{"number"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted by title archive", dataProviderClass = StaticDataProvider.class)
    public void FindByTitleCommandNothingRequiredPositiveTest(List<Book> books) {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("title", new String[0]);
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(books);
        assertEquals(actual, expected);
    }

    @Test
    public void FindByTitleCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("title", new String[]{"Ralph Johnson: Complete Work"});
        Response actual = controller.doGet("find", requestData);
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        Response expected = ResponseHelper.makeOkResponse(foundBooks);
        assertEquals(actual, expected);
    }

    @Test
    public void FindByTitleCommandNotFoundPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("title", new String[]{"Ralph Johnson"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted by authors archive", dataProviderClass = StaticDataProvider.class)
    public void FindByAuthorsCommandNothingRequiredPositiveTest(List<Book> books) {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("author", new String[0]);
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(books);
        assertEquals(actual, expected);
    }

    @Test
    public void FindByAuthorsCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("author", new String[]{"Ralph Johnson"});
        Response actual = controller.doGet("find", requestData);
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        Response expected = ResponseHelper.makeOkResponse(foundBooks);
        assertEquals(actual, expected);
    }

    @Test
    public void FindByAuthorCommandNotFoundPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("author", new String[]{"Ralson"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
        assertEquals(actual, expected);
    }

    @Test
    public void FindByPriceCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("price", new String[]{"200", "300"});
        Response actual = controller.doGet("find", requestData);
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(new Book(6, "Граф Монте-Кристо", new String[]{"Александр Дюма"}, 236.523, 619));
        foundBooks.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"}, 236.99, 312));
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        Response expected = ResponseHelper.makeOkResponse(foundBooks);
        assertEquals(expected, actual);
    }

    @Test
    public void FindByPriceCommandNotFoundPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("price", new String[]{"0", "10"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sorted by price archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPriceCommandNothingRequiredPositiveTest(List<Book> books) {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("price", new String[0]);
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(books);
        assertEquals(actual, expected);
    }

    @Test()
    public void findByPriceCommandNegativeParsingTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("price", new String[]{"number", "four"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }

    @Test
    public void FindByPagesCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("pages", new String[]{"400", "500"});
        Response actual = controller.doGet("find", requestData);
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(new Book(8, "Hotel", new String[]{"Arthur Hailey"}, 450.211, 425));
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Work",
                new String[]{"Ralph Johnson"}, 236.99, 448));
        Response expected = ResponseHelper.makeOkResponse(foundBooks);
        assertEquals(expected, actual);
    }

    @Test
    public void FindByPagesCommandNotFoundPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("pages", new String[]{"-50", "-10"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted by pages archive", dataProviderClass = StaticDataProvider.class)
    public void FindByPagesCommandNothingRequiredPositiveTest(List<Book> books) {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("pages", new String[0]);
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeOkResponse(books);
        assertEquals(actual, expected);
    }

    @Test()
    public void findByPagesCommandNegativeParsingTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("pages", new String[]{"number"});
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }

    @Test
    public void FindCommandEmptyDataTest() {
        Map<String, String[]> requestData = new HashMap<>();
        Response actual = controller.doGet("find", requestData);
        Response expected = ResponseHelper.makeErrorResponse("impossible define what find");
        assertEquals(expected, actual);
    }
}
