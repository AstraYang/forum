package com.forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.mapper.StickVoMapper;
import com.forum.service.StickVoService;
import com.forum.vo.StickVo;

/**
 * 主贴Service实现类
 */
@Service
public class StickVoServiceImpl implements StickVoService{
	@Resource
	StickVoMapper stickVoMapper;
	@Override
	public List<StickVo> getStickVos() {
		return stickVoMapper.getStickVos();
	}

	@Override
	public List<StickVo> getUserStick(Integer uID) {
		return stickVoMapper.getUserStick(uID);
	}

	@Override
	public List<StickVo> getStarStickByUserID(Integer uID) {
		return stickVoMapper.getStarStickByUserID(uID);
	}

	@Override
	public StickVo getStickByMID(Integer mID) {
		return stickVoMapper.getStickByMID(mID);
	}

}
