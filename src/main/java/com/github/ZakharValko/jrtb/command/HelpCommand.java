package com.github.ZakharValko.jrtb.command;

import com.github.ZakharValko.jrtb.command.Command;
import com.github.ZakharValko.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.ZakharValko.jrtb.command.CommandName.*;


/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"
                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n"
                    + "%s - получить статистику активных пользователей\n",
            START.getCommandName(),STOP.getCommandName(), HELP.getCommandName(), STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
