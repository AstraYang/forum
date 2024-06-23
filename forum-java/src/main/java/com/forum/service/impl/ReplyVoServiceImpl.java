package com.forum.service.impl;

import com.forum.mapper.ReplyVoMapper;
import com.forum.service.ReplyVoService;
import com.forum.vo.ReplyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyVoServiceImpl implements ReplyVoService{
    @Resource
    ReplyVoMapper replyVoMapper;

    @Override
    public List<ReplyVo> getReplyAndUser(Integer mID) {
        return replyVoMapper.getReplyAndUser(mID);
    }

    @Override
    public List<ReplyVo> getReplyInUStick(Integer uID) {
        return replyVoMapper.getReplyInUStick(uID);
    }
}
