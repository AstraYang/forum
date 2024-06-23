package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.Picture;

import java.util.List;

/**
 * 图片Service接口
 */
public interface PictureService extends IService<Picture> {
    int addPicture(Integer mID,Integer uID,String pName);
    //按mID获得图片
    List<Picture> getPicturesAsMID(Integer mID);
}
