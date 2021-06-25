package com.github.ZakharValko.jrtb.service;

import com.github.ZakharValko.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.ZakharValko.jrtb.repository.entity.GroupSub;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
