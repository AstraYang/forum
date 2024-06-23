package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.MainStick;

/**
 * 主贴Service接口
 */
public interface StickService extends IService<MainStick>{
    boolean addMLike(Integer mLike,Integer mID);
    boolean addStars(Integer mStars,Integer mID);
    boolean checkStarred(Integer mID,Integer uID);
    boolean addStarStick(Integer uID,Integer mID);
    boolean addReplies(Integer mReplies,Integer mID);
}
