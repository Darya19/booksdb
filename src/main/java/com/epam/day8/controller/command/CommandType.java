package com.epam.day8.controller.command;

import com.epam.day8.controller.command.impl.AddCommand;
import com.epam.day8.controller.command.impl.FindCommand;
import com.epam.day8.controller.command.impl.RemoveCommand;

public enum CommandType {
    ADD {{
        this.command = new AddCommand();
    }},
    REMOVE {{
        this.command = new RemoveCommand();
    }},
    FIND {{
        this.command = new FindCommand();
    }};

    Command command;

    public Command getCommand() {
        return command;
    }
}
