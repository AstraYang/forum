package com.forum.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 主贴类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "mainStick")
public class MainStick {
	  //主贴ID
    @TableId(value = "mID", type = IdType.AUTO)
	private Integer mID;

	 //社区ID
    @TableField(value = "cID")
	private Integer cID;
    

	 //用户ID
    @TableField(value = "uID")
	private Integer uID;

	 // 主贴标题
    @TableField(value = "mTitle")
	private String mTitle;

	 // 主贴内容
    @TableField(value = "mContent")
	private String mContent;

	 //主帖发布时间
    @TableField(value = "mCreateTime")
	private String mCreateTime;

	 //主贴点击次数
    @TableField(value = "mClicks")
	private Integer mClicks;

	 //主贴回复次数
    @TableField(value = "mReplies")
	private Integer mReplies;

	 //主贴点赞次数
    @TableField(value = "mLike")
	private Integer mLike;

	 //主贴收藏次数
    @TableField(value = "mStars")
	private Integer mStars;
}
