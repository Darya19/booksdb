package com.epam.day8.controller.command;

import com.epam.day8.controller.response.Response;

import java.util.Map;

public interface Command {

    Response execute(Map<String, String[]> data);
}
