package com.epam.day8.controller.command.impl;

import com.epam.day8.controller.command.Command;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;
import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.service.BookService;

import java.util.Map;

public class AddCommand implements Command {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHORS = "authors";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";

    @Override
    public Response execute(Map<String, String[]> data) {
        BookService service = new BookService();
        String[] title = data.get(TITLE);
        String[] authors = data.get(AUTHORS);
        String[] price = data.get(PRICE);
        String[] pages = data.get(PAGES);
        try {
            int updatedRows = service.addBook(title[0], authors, price[0], pages[0]);
            return ResponseHelper.makeOkResponse(updatedRows);
        } catch (BookServiceException e) {
            return ResponseHelper.makeErrorResponse(e.getMessage());
        }
    }
}

