package com.forum.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "starStick")
public class StarStick {
    /**
     * 收藏ID
     */
    @TableId(value = "starStick_ID",type = IdType.AUTO)
    private Integer starStick_ID;

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

}
