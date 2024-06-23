package com.forum.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVo {
    /**
     * 回复贴ID
     */
    @TableId(value = "rID",type = IdType.AUTO)
    private Integer rID;

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
     * 回复贴内容
     */
    @TableField(value = "rContent")
    private String rContent;

    /**
     * 回复贴时间
     */
    @TableField(value = "rCreateTime")
    private String rCreateTime;

    /**
     * 点赞次数
     */
    @TableField(value = "rLike")
    private Integer rLike;

    //用户部分信息
    /**
     * 用户名字
     */
    @TableField(value = "uName")
    private String uName;
    /**
     * 头像图片路径
     */
    @TableField(value = "uAvatar")
    private String uAvatar;
}
