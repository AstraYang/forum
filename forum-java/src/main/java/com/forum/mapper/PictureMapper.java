package com.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.model.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 图片Mapper接口
 */
public interface PictureMapper extends BaseMapper<Picture> {
    @Insert("insert into picture values(null,#{mID},#{uID},#{pName})")
    int addPicture(Integer mID,Integer uID,String pName);
    //按mID获得图片
    @Select("select * from picture where mID = #{mID} order by mID desc")
    List<Picture> getPicturesAsMID(Integer mID);
}
