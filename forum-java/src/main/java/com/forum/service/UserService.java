package com.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.User;

/**
 * 用户Service接口
 */
public interface UserService extends IService<User> {
    int updateUImg(Integer uID,String img);
}
