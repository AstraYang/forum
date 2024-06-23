package com.forum.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StickVo implements Serializable {
	/**
	 * 主贴ID
	 */
	@TableId(value = "mID", type = IdType.AUTO)
	private Integer mID;
	/**
	 * 主贴标题
	 */
	@TableField(value = "mTitle")
	private String mTitle;
	/**
	 * 主贴内容
	 */
	@TableField(value = "mContent")
	private String mContent;
	/**
	 * 主贴回复次数
	 */
	@TableField(value = "mReplies")
	private Integer mReplies;
	/**
	 * 主贴点赞次数
	 */
	@TableField(value = "mLike")
	private Integer mLike;
	/**
	 * 主贴收藏次数
	 */
	@TableField(value = "mStars")
	private Integer mStars;
	
	/**
	 * 用户ID
	 */
	@TableField(value = "uID")
	private Integer uID;
    
    /**
	 * 用户名
	 */
    @TableField(value = "uName")
	private String uName;

    /**
   	 * 用户头像
   	 */
    @TableField(value = "uAvatar")
	private String uAvatar;

}
