package com.epam.day8.controller.command.impl;

import com.epam.day8.controller.command.Command;
import com.epam.day8.controller.response.Response;
import com.epam.day8.controller.response.ResponseHelper;

import java.util.Map;

public class EmptyCommand implements Command {

    @Override
    public Response execute(Map<String, String[]> data) {
        return ResponseHelper.makeErrorResponse("Command don't set");
    }
}
