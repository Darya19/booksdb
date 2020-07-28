package com.epam.day8.controllertest;

import com.epam.day8.controller.BookController;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;


public class ControllerAddCommandTest {

    BookController controller;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
    }

    @Test
    public void addCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        String[] title = new String[1];
        title[0] = "Harry Potter and the chamber of secrets";
        requestData.put("title", title);
        String[] authors = new String[1];
        authors[0] = "J.K. Rowling";
        requestData.put("authors", authors);
        String[] price = new String[1];
        price[0] = "942.38";
        requestData.put("price", price);
        String[] pages = new String[1];
        pages[0] = "615";
        requestData.put("pages", pages);
        Response actual = controller.doGet("add", requestData);
        Response expected = ResponseHelper.makeOkResponse(1);
        assertEquals(actual, expected);
    }

    @Test(priority = 1, dataProvider = "invalid book", dataProviderClass = StaticDataProvider.class)
    public void addCommandNegativeValidationTest(Map<String, String[]> data) {
        Response actual = controller.doGet("add", data);
        Response expected = ResponseHelper.makeErrorResponse("invalid input data");
        assertEquals(actual, expected);
    }

    @Test(priority = 1, dataProvider = "incorrect book", dataProviderClass = StaticDataProvider.class)
    public void addCommandNegativeParsingTest(Map<String, String[]> data) {
        Response actual = controller.doGet("add", data);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(actual, expected);
    }
}
