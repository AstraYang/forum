package com.forum.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.mapper.StickMapper;
import com.forum.model.MainStick;
import com.forum.service.StickService;

import javax.annotation.Resource;

/**
 * 主贴Service实现类
 */
@Service
public class StickServiceImpl extends ServiceImpl<StickMapper, MainStick> implements StickService{
    @Resource
    StickMapper stickMapper;

    @Override
    public boolean addMLike(Integer mLike, Integer mID) {
        return stickMapper.addMLike(mLike,mID);
    }

    @Override
    public boolean addStars(Integer mStars, Integer mID) {
        return stickMapper.addStars(mStars,mID);
    }

    @Override
    public boolean checkStarred(Integer mID, Integer uID) {
        if(stickMapper.checkStarred(mID,uID)==0){
            return false;
        }
        return true;
    }

    @Override
    public boolean addStarStick(Integer uID, Integer mID) {
        return stickMapper.addStarStick(uID,mID);
    }

    @Override
    public boolean addReplies(Integer mReplies, Integer mID) {
        return stickMapper.addReplies(mReplies,mID);
    }
}
