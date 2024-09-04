package com.forum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.forum.model.Picture;
import com.forum.service.PictureService;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.api.R;
import com.forum.model.MainStick;
import com.forum.service.StickVoService;
import com.forum.service.StickService;
import com.forum.vo.StickVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
*帖子controller控制器
*/
@RestController
@RequestMapping("/stick")
public class StickController {
	@Resource
	StickService stickService;
	@Resource
	StickVoService stickVoService;
	@Resource
	PictureService pictureService;
	
	@GetMapping("/test")
	public R test() {
		return R.ok("测试");
	}
	
	/**
	 * 获取所有帖子（包含用户部分信息
	 */
	@PostMapping("/getSticks")
	public R getSticks() {
		System.err.println("--获取所有帖子--");
		//获取帖子文本内容
		List<StickVo> sticks=stickVoService.getStickVos();
		//获取帖子图片内容 每个帖子的图片只发送一张图片
		List<Picture> pictures=new ArrayList<Picture>();
		int m=0;
		for (Picture p : pictureService.list()) {
			if(m != p.getMID()){ //根据mID来筛选
				m = p.getMID();
				pictures.add(p);
			}
		}
		//发送信息
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("sticks", sticks);
		resultMap.put("pictures", pictures);
		return R.ok(resultMap);
	}

	/**
	 * 按mID获得主贴信息（包含用户部分信息
	 */
	@GetMapping("/getStick/{mID}")
	public R getStick(@PathVariable Integer mID){
		System.err.println("--按mID获得主贴信息----");
		//按mID获得主贴信息
		StickVo stickVo = stickVoService.getStickByMID(mID);
		//按mID获得图片
		List<Picture> pictures = pictureService.getPicturesAsMID(mID);
		//存放到resultMap
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("stickVo",stickVo);
		resultMap.put("pictures",pictures);
		//返回信息
		return R.ok(resultMap);
	}

	/**
	 * 按uID获取该用户的主贴
	 */
	@GetMapping("/getUserSticks/{uid}")
	public R getUserSticks(@PathVariable("uid") Integer uID) {
		System.err.println("--按uID获取指定帖子--");
		//获取帖子文本内容
		List<StickVo> sticks=stickVoService.getUserStick(uID);
		System.out.println("stuck:");
		System.out.println(sticks);
		//发送信息
		return R.ok(sticks);
	}

	/**
	 * 按uid获取收藏帖
	 */
	@GetMapping("/getStarSticks/{uid}")
	public R getStarSticks(@PathVariable("uid") Integer uID) {
		System.err.println("--按uID获取收藏帖子--");
		//获取帖子文本内容
		List<StickVo> sticks=stickVoService.getStarStickByUserID(uID);
		System.out.println("stuck:");
		System.out.println(sticks);
		//发送信息
		return R.ok(sticks);
	}


	/**
	 * 添加帖子文本内容
	 */
	@PostMapping("/addStickContent")
	public R addStickContent(@RequestParam("uID")Integer uID,
							 @RequestParam("mTitle")String mTitle,
							 @RequestParam("mContent")String mContent){
		System.err.println("---添加帖子文本内容----");
		System.out.println(uID);
		System.out.println("mTitle:"+mTitle);
		System.out.println("mContent:"+mContent);
		//存储帖子文本内容
		MainStick mainStick=new MainStick();
		mainStick.setUID(uID);
		mainStick.setMTitle(mTitle);
		mainStick.setMContent(mContent);
		//执行方法并返回Map值
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("vStick",stickService.save(mainStick));
		resultMap.put("mID",mainStick.getMID());
		return R.ok(resultMap);
	}

	/**
	 * 添加帖子文本图片内容
	 */
	@PostMapping("/addStickPicture")
	public R addStick(@RequestParam("mID")Integer mID,@RequestParam("uID")Integer uID,HttpServletRequest req){
		System.err.println("---添加帖子----");
		System.out.println(mID);
		System.out.println(uID);
		System.out.println(" ");
		//存储数据
		FileMethod fileMethod=new FileMethod();
		String respFileName=fileMethod.uploadFile(req);
		//存储图片信息
		Picture p = new Picture();
		p.setMID(mID);
		p.setUID(uID);
		p.setPName(respFileName);
		boolean vPicture = pictureService.save(p);
		return R.ok(vPicture);
	}

	/**
	 * 修改帖子
	 */
	@PostMapping("/updateStick")
	public R updateStickBymID(@RequestParam("mID")Integer mID,
							  @RequestParam("mTitle")String mTitle,
							  @RequestParam("mContent")String mContent){
		//装载
		MainStick mainStick = new MainStick();
		mainStick.setMID(mID);
		mainStick.setMTitle(mTitle);
		mainStick.setMContent(mContent);
		//执行
		return R.ok(stickService.updateById(mainStick));
	}

	/**
	 * 删除帖子（只删除数据库信息
	 */
	@PostMapping("/delStickBymID")
	public R delStickBymID(@RequestParam("mID")Integer mID){
		return R.ok(stickService.removeById(mID));
	}


	/**
	 * 点赞
	 *
	 */
	@GetMapping("/addMLike/{mLike}/{mID}")
	public R addMLike(@PathVariable("mLike")Integer mLike,@PathVariable("mID")Integer mID){
		return R.ok(stickService.addMLike(mLike,mID));
	}
	/**
	 * 收藏
	 */

	@GetMapping("/checkStarred/{mID}/{uID}")
	public R checkStarred(@PathVariable("mID")Integer mID,@PathVariable("uID")Integer uID){
		System.err.println("---判断收藏----");
		return R.ok(stickService.checkStarred(mID,uID));
	}
	@GetMapping("/addStarStick/{uID}/{mID}")
	public R addStarStick(@PathVariable("uID")Integer uID,@PathVariable("mID")Integer mID){
		System.err.println("---添加收藏----");

		return R.ok(stickService.addStarStick(uID,mID));
	}

	@GetMapping("/addMStars/{mStars}/{mID}")
	public R addMStars(@PathVariable("mStars")Integer mStars,@PathVariable("mID")Integer mID){
		return R.ok(stickService.addStars(mStars,mID));
	}

}
