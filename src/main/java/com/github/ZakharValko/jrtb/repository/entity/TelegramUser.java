package com.github.ZakharValko.jrtb.repository.entity;


import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tg_user")
public class TelegramUser {

    @Id
    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "active_or_not")
    private boolean active;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<GroupSub> groupSubs;
}
