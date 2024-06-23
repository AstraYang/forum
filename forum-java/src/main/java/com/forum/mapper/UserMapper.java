package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.model.User;
import org.apache.ibatis.annotations.Update;

/**
 * 用户Mapper接口
 */
public interface UserMapper extends BaseMapper<User>{
    @Update("UPDATE `user` set uAvatar=#{img} where uID=#{uID}")
    int updateUImg(Integer uID,String img);
}
