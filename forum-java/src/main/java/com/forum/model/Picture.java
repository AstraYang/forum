package com.forum.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *图片表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Picture" )
public class Picture {
	/**
	 * 图片ID
	 */
	@TableId(value = "pID",type = IdType.AUTO)
	private Integer pID;
	
	/**
	 * 主贴ID
	 */
	@TableField(value = "mID")
	private Integer mID;

	/**
	 * 用户ID
	 */
	@TableField(value = "uID")
	private Integer uID;

	/**
	 * 图片ID
	 */
	@TableField(value = "pName")
	private String pName;

}
