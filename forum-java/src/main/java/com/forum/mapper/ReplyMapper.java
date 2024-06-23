package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.model.Reply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 回复Service接口
 */
public interface ReplyMapper extends BaseMapper<Reply> {
    /**
     * 根据mID获取回复贴
     * */
    @Select("select * from Reply where mID = #{mID}")
    List<Reply> getReplyAsMID(Integer mID);

    /**
     * 简单点赞实现
     * */
    @Update("update Reply set rLike=#{rLike} where rID=#{rID}")
    boolean addRLike(Integer rLike,Integer rID);

    /**
     * 获取该用户帖子的回复帖
    * */
    @Select("select * from reply r WHERE r.mID in( \n" +
            "select m.mID \n" +
            "from `user` u ,mainstick m \n" +
            "where u.uID = m.uID and u.uID = #{uID})")
    List<Reply> getReplyAsUID(Integer uID);

    /**
     *根据mID获取回复贴数量
    * */
    @Select("select COUNT(rID) from Reply where mID = #{mID}")
    int getReplyCountAsMID(Integer mID);

    /**
     *回复贴数量保存到主贴
     * */
    @Update("update mainStick set mReplies=#{mReplies} where mID=#{mID}")
    boolean saveReplyCount(Integer mID,Integer mReplies);
}
