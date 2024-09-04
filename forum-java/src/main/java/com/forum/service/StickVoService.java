package com.forum.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.MainStick;
import com.forum.vo.StickVo;

/**
 * StickVosService接口
 */
public interface StickVoService{
	//获取所有用户和贴子信息
	List<StickVo> getStickVos();
	//按用户ID获取主贴
	List<StickVo> getUserStick(Integer uID);
	//按用户ID获取收藏贴
	List<StickVo> getStarStickByUserID(Integer uID);
	//按mID获取主贴
	StickVo getStickByMID(Integer mID);
}
