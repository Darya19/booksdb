package com.epam.day8.controllertest;

import com.epam.day8.controller.BookController;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class ControllerRemoveCommandTest {
    BookController controller;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
    }

    @Test
    public void removeCommandPositiveTest() {
        Map<String, String[]> requestData = new HashMap<>();
        requestData.put("title", new String[]{"Winnie-the-Pooh"});
        requestData.put("authors", new String[]{"Alan Alexander Milne", "P.G.Wodehouse"});
        requestData.put("price", new String[]{"458.96"});
        requestData.put("pages", new String[]{"194"});
        Response actual = controller.doGet("remove", requestData);
        Response expected = ResponseHelper.makeOkResponse(1);
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "invalid book", dataProviderClass = StaticDataProvider.class)
    public void removeCommandNegativeValidationTest(Map<String, String[]> data) {
        Response actual = controller.doGet("remove", data);
        Response expected = ResponseHelper.makeErrorResponse("invalid input data");
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "incorrect book", dataProviderClass = StaticDataProvider.class)
    public void removeCommandNegativeParsingTest(Map<String, String[]> data) {
        Response actual = controller.doGet("remove", data);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }
}
