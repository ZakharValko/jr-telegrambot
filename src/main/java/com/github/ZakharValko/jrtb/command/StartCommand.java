package com.github.ZakharValko.jrtb.command;

import com.github.ZakharValko.jrtb.repository.entity.TelegramUser;
import com.github.ZakharValko.jrtb.service.SendBotMessageService;
import com.github.ZakharValko.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я JavaRush Telegram Bot. Я помогу тебе быть в курсе последних статей тех авторов, котрые тебе интересны.\n\n"
            + "Нажимай на /addGroupSub чтобы подписаться на группу статей в JavaRush.\n"
            + "Не знавешь о чем я? Нажми /help, чтобы узнать, что я умею!";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;

    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
