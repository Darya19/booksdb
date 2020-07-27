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

public class ControllerFindCommandTest {

//    BookController controller;
//    BookArchive archive;
//
//    @BeforeClass
//    public void setUp() {
//        controller = BookController.getInstance();
//        archive = BookArchive.getArchive();
//    }
//
//    @Test
//    public void FindByIdCommandPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("id", "5");
//        Response actual = controller.doGet("find", requestData);
//        List<Book> foundBooks = new ArrayList<>();
//        List<String> authors = new ArrayList<>();
//        authors.add("Ralph Johnson");
//        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
//        Response expected = ResponseHelper.makeOkResponse(foundBooks);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByIdCommandNotFoundPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("id", "8");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
//        assertEquals(expected, actual);
//    }
//
//    @Test()
//    public void findByIdCommandNegativeParsingTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("id", "number");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByTitleCommandPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("title", "Ralph Johnson: Complete Works");
//        Response actual = controller.doGet("find", requestData);
//        List<Book> foundBooks = new ArrayList<>();
//        List<String> authors = new ArrayList<>();
//        authors.add("Ralph Johnson");
//        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
//        Response expected = ResponseHelper.makeOkResponse(foundBooks);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByTitleCommandNotFoundPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("title", "Ralph Johnson");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByAuthorsCommandPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("author", "Ralph Johnson");
//        Response actual = controller.doGet("find", requestData);
//        List<Book> foundBooks = new ArrayList<>();
//        List<String> authors = new ArrayList<>();
//        authors.add("Erich Gamma");
//        authors.add("Richard Helm");
//        authors.add("Ralph Johnson");
//        authors.add("John Vlissides");
//        foundBooks.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
//                authors, 236.99, 312));
//        authors = new ArrayList<>();
//        authors.add("Ralph Johnson");
//        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
//        Response expected = ResponseHelper.makeOkResponse(foundBooks);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByAuthorCommandNotFoundPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("author", "Ralson");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByPriceCommandPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("price", "236.99");
//        Response actual = controller.doGet("find", requestData);
//        List<Book> foundBooks = new ArrayList<>();
//        List<String> authors = new ArrayList<>();
//        authors.add("Erich Gamma");
//        authors.add("Richard Helm");
//        authors.add("Ralph Johnson");
//        authors.add("John Vlissides");
//        foundBooks.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
//                authors, 236.99, 312));
//        authors = new ArrayList<>();
//        authors.add("Ralph Johnson");
//        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
//        Response expected = ResponseHelper.makeOkResponse(foundBooks);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByPriceCommandNotFoundPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("price", "100.0");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
//        assertEquals(expected, actual);
//    }
//
//    @Test()
//    public void findByPriceCommandNegativeParsingTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("price", "number");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByPagesCommandPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("pages", "448");
//        Response actual = controller.doGet("find", requestData);
//        List<Book> foundBooks = new ArrayList<>();
//        List<String> authors = new ArrayList<>();
//        authors.add("Ralph Johnson");
//        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
//        Response expected = ResponseHelper.makeOkResponse(foundBooks);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindByPagesCommandNotFoundPositiveTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("pages", "132");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeOkResponse(new ArrayList<>());
//        assertEquals(expected, actual);
//    }
//
//    @Test()
//    public void findByPagesCommandNegativeParsingTest() {
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("pages", "number");
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void FindCommandEmptyDataTest() {
//        Map<String, String> requestData = new HashMap<>();
//        Response actual = controller.doGet("find", requestData);
//        Response expected = ResponseHelper.makeErrorResponse("impossible define what find");
//        assertEquals(expected, actual);
//    }
}
