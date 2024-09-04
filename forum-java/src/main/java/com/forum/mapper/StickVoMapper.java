package com.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forum.vo.StickVo;

public interface StickVoMapper{
	//获取所有用户和贴子信息
	//	这个方法返回一个 List<StickVo>，包含所有帖子和对应用户的信息。
	//SQL 查询从 mainStick 表和 user 表中选择相关字段，并通过 uID 字段进行连接，按 mID 降序排列。
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID order by mID desc")
	List<StickVo> getStickVos();

	//按mID获取主贴（包含该用户信息
//	这个方法返回一个 StickVo 对象，包含指定 mID 的主贴和对应用户的信息。
//	SQL 查询从 mainStick 表和 user 表中选择相关字段，并通过 uID 字段进行连接，同时筛选出指定 mID 的主贴。
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID and m.mID=#{mID}")
	StickVo getStickByMID(Integer mID);

	//按用户ID获取主贴
	//这个方法返回一个 List<StickVo>，包含指定用户ID的所有主贴和对应用户的信息。
	//SQL 查询从 mainStick 表和 user 表中选择相关字段，并通过 uID 字段进行连接，同时筛选出指定用户ID的主贴。
	@Select("SELECT m.mID,m.mTitle,m.mContent,"
			+ "m.mReplies,m.mLike,m.mStars,"
			+ "u.uID,u.uName,u.uAvatar "
			+ "FROM mainStick m,`user` u "
			+ "WHERE u.uID=m.uID and m.uID=#{uID}")
    List<StickVo> getUserStick(Integer uID);

	//按用户ID获取收藏贴
	//这个方法返回一个 List<StickVo>，包含指定用户ID的所有收藏贴和对应用户的信息。
	//SQL 查询从 mainStick 表、starstick 表和 user 表中选择相关字段，并通过 mID 和 uID 字段进行连接，同时筛选出指定用户ID的收藏贴。
	@Select("SELECT m.mID, m.mTitle, m.mContent, m.mReplies, m.mLike, m.mStars, u.uID, u.uName, u.uAvatar "
			+ "FROM mainStick m "
			+ "JOIN starstick s ON m.mID = s.mID "
			+ "JOIN `user` u ON u.uID = s.uID "
			+ "WHERE s.uID = #{uID}")
	List<StickVo> getStarStickByUserID(Integer uID);
}
