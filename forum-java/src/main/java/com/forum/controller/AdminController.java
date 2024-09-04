package com.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.api.R;
import com.forum.model.Admin;
import com.forum.model.User;
import com.forum.service.*;
import com.forum.vo.StickVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;
    @Resource
    StickService stickService;
    @Resource
    StickVoService stickVoService;
    @Resource
    PictureService pictureService;

    /**
     * 登录验证
    * */
//    @PostMapping("/login")
//    public R login(@RequestParam("aName")String aName,@RequestParam("aPwd")String aPwd){
//        System.err.println("---这是Admin账号密码验证-------------");
//        //创建Wrapper对象
//        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>();
//        wrapper.eq("aName",aName).and(i->i.eq("aPwd",aPwd));
//        //查询
//        Admin admin=adminService.getOne(wrapper);
//        System.out.println(admin);
//        //响应数据
//        return R.ok(admin);
//    }
//    /**
//     * 修改管理员信息
//     * */
//    @PostMapping("/update")
//    public R update(@RequestBody Map<String, Object> map){
//        System.err.println("---修改管理员信息-------------");
//        //提取
//        boolean isOk = false;
//        if(map!=null){
//            Map<String, Object> newAdmin=(Map<String, Object>)map.get("adminData");
//            //装载
//            Admin admin = new Admin();
//            admin.setAID((int)newAdmin.get("uid"));
//            admin.setAName((String)newAdmin.get("aname"));
//            admin.setAPwd((String)newAdmin.get("apwd"));
//            //更改
//            isOk=adminService.updateById(admin);
//        }
//        return R.ok(isOk);
//    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("aName") String aName, @RequestParam("aPwd") String aPwd, Model model, RedirectAttributes redirectAttributes) {
        System.err.println("---这是Admin账号密码验证-------------");
        // 创建Wrapper对象
        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>();
        wrapper.eq("aName", aName).and(i -> i.eq("aPwd", aPwd));
        // 查询
        Admin admin = adminService.getOne(wrapper);
        System.out.println(admin);

        if (admin != null) {
            // 如果找到匹配的用户，跳转到成功页面
            return "index"; // 假设有一个成功页面
        } else {
            // 如果没有找到匹配的用户，重定向到登录页面并显示错误信息
            redirectAttributes.addFlashAttribute("error", "用户名或密码错误");
            return "login"; // 重定向到登录页面
        }
    }

}
