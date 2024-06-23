package com.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.vo.StickVo;

public interface StickVoMapper{
	//获取所有用户和贴子信息
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID order by mID desc")
	List<StickVo> getStickVos();

	//按mID获取主贴（包含该用户信息
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID and m.mID=#{mID}")
	StickVo getStickByMID(Integer mID);

	//按用户ID获取主贴
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID and m.uID=#{uID}")
    List<StickVo> getUserStick(Integer uID);

	//按用户ID获取收藏贴
	@Select("SELECT m.mID, m.mTitle, m.mContent, m.mReplies, m.mLike, m.mStars, u.uID, u.uName, u.uAvatar "
			+ "FROM mainStick m "
			+ "JOIN starstick s ON m.mID = s.mID "
			+ "JOIN `user` u ON u.uID = s.uID "
			+ "WHERE s.uID = #{uID}")
	List<StickVo> getStarStickByUserID(Integer uID);

}
