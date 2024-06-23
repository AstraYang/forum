package com.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.forum.model.Admin;
import com.forum.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    /**
     * 登录验证
    * */
    @PostMapping("/login")
    public R login(@RequestParam("aName")String aName,@RequestParam("aPwd")String aPwd){
        System.err.println("---这是Admin账号密码验证-------------");
        //创建Wrapper对象
        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>();
        wrapper.eq("aName",aName).and(i->i.eq("aPwd",aPwd));
        //查询
        Admin admin=adminService.getOne(wrapper);
        System.out.println(admin);
        //响应数据
        return R.ok(admin);
    }
    /**
     * 修改管理员信息
     * */
    @PostMapping("/update")
    public R update(@RequestBody Map<String, Object> map){
        System.err.println("---修改管理员信息-------------");
        //提取
        boolean isOk = false;
        if(map!=null){
            Map<String, Object> newAdmin=(Map<String, Object>)map.get("adminData");
            //装载
            Admin admin = new Admin();
            admin.setAID((int)newAdmin.get("uid"));
            admin.setAName((String)newAdmin.get("aname"));
            admin.setAPwd((String)newAdmin.get("apwd"));
            //更改
            isOk=adminService.updateById(admin);
        }
        return R.ok(isOk);
    }
}
