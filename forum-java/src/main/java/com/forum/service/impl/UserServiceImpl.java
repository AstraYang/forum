package com.forum.service.impl;

import com.forum.mapper.StickMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.mapper.UserMapper;
import com.forum.model.User;
import com.forum.service.UserService;

import javax.annotation.Resource;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Resource
    UserMapper userMapper;

    public int updateUImg(Integer uID,String img) {
        return userMapper.updateUImg(uID,img);
    }
}
