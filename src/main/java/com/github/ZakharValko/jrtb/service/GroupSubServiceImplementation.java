package com.github.ZakharValko.jrtb.service;

import com.github.ZakharValko.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.ZakharValko.jrtb.repository.entity.GroupSub;
import com.github.ZakharValko.jrtb.repository.entity.GroupSubRepository;
import com.github.ZakharValko.jrtb.repository.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

@Service
public class GroupSubServiceImplementation implements GroupSubService{

    private final GroupSubRepository groupSubRepository;
    private final TelegramUserService telegramUserService;

    @Autowired
    public GroupSubServiceImplementation(GroupSubRepository groupSubRepository, TelegramUserService telegramUserService){
        this.groupSubRepository = groupSubRepository;
        this.telegramUserService = telegramUserService;
    }



    @Override
    public GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo) {
        TelegramUser telegramUser = telegramUserService.findByChatId(chatId).orElseThrow(NotFoundException::new);

        GroupSub groupSub;
        Optional<GroupSub> groupSubFromDB = groupSubRepository.findById(groupDiscussionInfo.getId());
        if(groupSubFromDB.isPresent()){
            groupSub = groupSubFromDB.get();
            Optional<TelegramUser> first = groupSub.getUsers().stream()
                    .filter(it -> it.getChatId().equalsIgnoreCase(chatId))
                    .findFirst();
            if(first.isEmpty()){
                groupSub.addUser(telegramUser);
            }
        } else {
            groupSub = new GroupSub();
            groupSub.addUser(telegramUser);
            groupSub.setId(groupDiscussionInfo.getId());
            groupSub.setTitle(groupDiscussionInfo.getTitle());
        }
        return groupSubRepository.save(groupSub);
    }
}
