package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.mapper.ReplyMapper;
import com.forum.model.Reply;
import com.forum.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService{
    @Resource
    ReplyMapper replyMapper;

    /**
     * 根据mID获取回复贴
     * */
    @Override
    public List<Reply> getReplyAsMID(Integer mID) {
        return replyMapper.getReplyAsMID(mID);
    }

    /**
     * 简单点赞实现
     * */
    @Override
    public boolean addRLike(Integer rLike, Integer rID) {
        return replyMapper.addRLike(rLike,rID);
    }

    /**
     * 获取该用户帖子的回复帖
     * */
    @Override
    public List<Reply> getReplyAsUID(Integer uID) {
        return replyMapper.getReplyAsUID(uID);
    }

    /**
     *根据mID获取回复贴数量
     * */
    @Override
    public int getReplyCountAsMID(Integer mID) {
        return replyMapper.getReplyCountAsMID(mID);
    }

    /**
     *回复贴数量保存到主贴
     * */
    @Override
    public boolean saveReplyCount(Integer mID, Integer mReplies) {
        return replyMapper.saveReplyCount(mID,mReplies);
    }

}
