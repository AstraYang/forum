package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.Reply;

import java.util.List;

public interface ReplyService extends IService<Reply> {
    List<Reply> getReplyAsMID(Integer mID);

    boolean addRLike(Integer rLike,Integer rID);

    List<Reply> getReplyAsUID(Integer uID);

    int getReplyCountAsMID(Integer mID);

    boolean saveReplyCount(Integer mID,Integer mReplies);
}
