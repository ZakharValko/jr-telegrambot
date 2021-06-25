package com.github.ZakharValko.jrtb.javarushclient.dto;

import lombok.Data;

@Data
public class UserDiscussionInfo {

    private boolean isBookmarked;
    private Integer lastLime;
    private Integer newCommentsCount;

}
