package com.forum.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 社区类
 */
@TableName(value = "Comm")
public class Comm {
	/**
	 * 社区ID
	 */
	@TableId(value = "cID",type = IdType.AUTO)
	private Integer cID;
	
	/**
	 * 社区名
	 */
	@TableField(value = "cName")
	private String cName;
	
	/**
	 * 社区介绍
	 */
	@TableField(value = "cShow")
	private String cShow;
	
	public Integer getcID() {
		return cID;
	}
	public void setcID(Integer cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcShow() {
		return cShow;
	}
	public void setcShow(String cShow) {
		this.cShow = cShow;
	}
	
	
	
	
	
}
