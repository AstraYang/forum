package com.forum.mapper;

import com.forum.vo.ReplyVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReplyVoMapper {
    //根据主贴ID获取回复贴和回复者信息
    @Select("select r.*, u.uName, u.uAvatar \n" +
            "from reply r, `user` u \n" +
            "where r.uID = u.uID \n" +
            "and r.mID = #{mID}")
    List<ReplyVo> getReplyAndUser(Integer mID);

    //获取该用户帖子的回复帖（里面包含用户信息
    @Select("select r.*, u.uName, u.uAvatar " +
            "from reply r, `user` u " +
            "where r.uID = u.uID and r.mID " +
            "in(select m.mID from `user` u ,mainstick m where u.uID = m.uID and u.uID = #{uID})")
    List<ReplyVo> getReplyInUStick(Integer uID);

}
