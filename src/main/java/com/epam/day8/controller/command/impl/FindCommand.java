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

public class FindCommand implements Command {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";
    private static final String WORD_IN_TITLE = "word";
    List<Book> foundBooks;

    @Override
    public Response execute(Map<String, String[]> data) {
        if (data == null || data.isEmpty()) {
            return ResponseHelper.makeErrorResponse("impossible define what find");
        }
        BookService service = new BookService();
        List<String> command = new ArrayList<>();
        for (String key : data.keySet()) {
            command.add(key);
        }
        try {
            switch (command.get(0)) {
                case ID:
                    foundBooks = service.findById(data.get(command.get(0)));
                    break;
                case TITLE:
                    foundBooks = service.findByTitle(data.get(command.get(0)));
                    break;
                case AUTHOR:
                    foundBooks = service.findByAuthor(data.get(command.get(0)));
                    break;
                case PRICE:
                    foundBooks = service.findByPrice(data.get(command.get(0)));
                    break;
                case PAGES:
                    foundBooks = service.findByPages(data.get(command.get(0)));
                    break;
            }
            return ResponseHelper.makeOkResponse(foundBooks);
        } catch (BookServiceException e) {
            return ResponseHelper.makeErrorResponse(e.getMessage());
        }
    }
}

