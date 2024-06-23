package com.forum.model;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User {
	/**
	 * 用户ID
	 */
    @TableId(value = "uID", type = IdType.AUTO)
	private Integer uID;
    
    /**
	 * 用户名
	 */
    @TableField(value = "uName")
	private String uName;
    
    /**
   	 * 用户性别
   	 */
    @TableField(value = "uSex")
	private Integer uSex;
	
	/**
   	 * 用户性别
   	 */
    @TableField(value = "grade")
	private Integer grade;
    
    /**
   	 * 用户个性签名
   	 */
    @TableField(value = "autograph")
	private String autograph;
    
    /**
   	 * 用户电话
   	 */
    @TableField(value = "uPhone")
	private String uPhone;
    
    /**
   	 * 用户邮箱
   	 */
    @TableField(value = "uEmail")
	private String uEmail;

    /**
   	 * 用户密码
   	 */
    @TableField(value = "uPwd")
	private String uPwd;

    /**
   	 * 用户创建时间
   	 */
    @TableField(value = "uCreateTime")
	private String uCreateTime;

    /**
   	 * 用户头像
   	 */
    @TableField(value = "uAvatar")
	private String uAvatar;
    
    /**
   	 * 帖子
   	 */
//    @TableField(exist = false)
//    private List<MainStick> sticks;
//
}
