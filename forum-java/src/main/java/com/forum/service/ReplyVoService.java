package com.forum.service;

import com.forum.vo.ReplyVo;

import java.util.List;

public interface ReplyVoService {
    List<ReplyVo> getReplyAndUser(Integer mID);

    List<ReplyVo> getReplyInUStick(Integer uID);
}
