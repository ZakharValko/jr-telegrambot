package com.github.ZakharValko.jrtb.command;

import static com.github.ZakharValko.jrtb.command.CommandName.STAT;
import static com.github.ZakharValko.jrtb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandClass{
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
