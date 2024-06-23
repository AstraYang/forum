package com.forum.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.model.MainStick;
import com.forum.vo.StickVo;

/**
 * StickVosService接口
 */
public interface StickVoService{

	List<StickVo> getStickVos();

	List<StickVo> getUserStick(Integer uID);
	List<StickVo> getStarStickByUserID(Integer uID);

	StickVo getStickByMID(Integer mID);
}
