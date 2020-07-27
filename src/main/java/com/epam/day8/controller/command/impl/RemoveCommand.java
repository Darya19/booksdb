package com.epam.day8.controller.command.impl;

import com.epam.day8.controller.command.Command;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;
import com.epam.day8.exception.BookServiceException;
import com.epam.day8.model.entity.Book;
import com.epam.day8.model.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemoveCommand implements Command {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHORS = "authors";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";

    @Override
    public Response execute(Map<String, String[]> data) {
        BookService service = new BookService();
        String[] title = data.get(TITLE);
        List<String> authors = new ArrayList<>();
        String[] authorMassive = data.get(AUTHORS);
        for (String author : authorMassive) {
            authors.add(author);
        }
        String[] price = data.get(PRICE);
        String[] pages = data.get(PAGES);
        try {
            int updatedRows = service.removeBook(title[0], authors, price[0], pages[0]);
            return ResponseHelper.makeOkResponse(updatedRows);
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(e.getMessage());
        } catch (BookServiceException e) {
            return ResponseHelper.makeErrorResponse(e.getMessage());
        }
    }
}
