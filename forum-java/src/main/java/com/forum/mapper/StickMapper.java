package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.model.MainStick;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 主贴Mapper接口
 */
public interface StickMapper extends BaseMapper<MainStick>{
    //简单点赞实现
    @Update("update MainStick set mLike=#{mLike} where mID=#{mID}")
    boolean addMLike(Integer mLike,Integer mID);
    //简单收藏实现
    @Update("update MainStick set mStars=#{mStars} where mID=#{mID}")
    boolean addStars(Integer mStars,Integer mID);
    //简单评论数实现
    @Update("update MainStick set mReplies=#{mReplies} where mID=#{mID}")
    boolean addReplies(Integer mReplies,Integer mID);
    //判断是否收藏
    @Select("select COUNT(*) from starStick where mID=#{mID} and uID=#{uID}")
    int checkStarred(Integer mID, Integer uID);
    //记录收藏帖子
    @Insert("insert into starStick values(null,#{mID},#{uID})")
    boolean addStarStick(Integer uID, Integer mID);
}
