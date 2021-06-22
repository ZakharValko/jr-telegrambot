package com.github.ZakharValko.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.ZakharValko.jrtb.command.CommandName.STOP;
import static com.github.ZakharValko.jrtb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit level testing for StartCommand")
public class StopCommandTest extends AbstractCommandClass{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}
