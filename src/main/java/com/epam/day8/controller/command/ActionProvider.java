package com.epam.day8.controller.command;

import com.epam.day8.controller.command.impl.EmptyCommand;

public class ActionProvider {

    public static Command defineCommand(String request) {
        Command command;
        if (request == null || request.isEmpty()) {
            return new EmptyCommand();
        } else {
            CommandType commandType = CommandType.valueOf(request.toUpperCase());
            command = commandType.getCommand();
        }
        return command;
    }
}
