package com.forum.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *admin类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Admin")
public class Admin {
	/**
	 * 管理员ID
	 */
	@TableId(value = "aID",type = IdType.AUTO)
	private Integer aID; 
	
	/**
	 * 管理员名字
	 */
	@TableField(value = "aName")
	private String aName; 
	
	/**
	 * 管理员密码
	 */
	@TableField(value = "aPwd")
	private String aPwd;
				
}
