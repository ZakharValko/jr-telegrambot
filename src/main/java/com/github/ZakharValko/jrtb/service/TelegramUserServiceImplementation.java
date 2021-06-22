package com.github.ZakharValko.jrtb.service;

import com.github.ZakharValko.jrtb.repository.entity.TelegramUser;
import com.github.ZakharValko.jrtb.repository.entity.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelegramUserServiceImplementation implements TelegramUserService{

    private final TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserServiceImplementation(TelegramUserRepository telegramUserRepository){
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);

    }

    @Override
    public List<TelegramUser> retrieveAllActiveUsers() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }
}
