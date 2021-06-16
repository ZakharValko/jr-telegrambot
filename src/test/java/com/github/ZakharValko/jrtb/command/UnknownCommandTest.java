package com.github.ZakharValko.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.ZakharValko.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level tests for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandClass{

    @Override
    String getCommandName() {
        return "/sdjkfghj";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
