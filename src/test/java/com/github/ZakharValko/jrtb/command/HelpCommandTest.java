package com.github.ZakharValko.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.ZakharValko.jrtb.command.CommandName.HELP;
import static com.github.ZakharValko.jrtb.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandClass{


    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
