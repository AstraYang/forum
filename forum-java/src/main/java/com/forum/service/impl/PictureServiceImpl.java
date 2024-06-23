package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.mapper.PictureMapper;
import com.forum.model.Picture;
import com.forum.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
    @Resource
    PictureMapper pictureMapper;

    @Override
    public int addPicture(Integer mID, Integer uID, String pName) {
        return pictureMapper.addPicture(mID, uID, pName);
    }

    @Override
    public List<Picture> getPicturesAsMID(Integer mID) {
        return pictureMapper.getPicturesAsMID(mID);
    }
}
