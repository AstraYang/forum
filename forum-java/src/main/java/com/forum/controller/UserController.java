package com.forum.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.forum.model.User;
import com.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/test")
	public void test() {
		int count= userService.count();
		System.out.println(count);
	}
	
	@PostMapping("/getUsers")
	public R getUsers() {
		List<User> users=userService.list();
		Map<String, Object> resultMap=new HashMap<String,Object>();
		resultMap.put("users", users);
		return R.ok(resultMap);
	}
	
	/**
	 * 账号密码验证
	 */
	@PostMapping("/getLogin")
	public R login(@RequestBody HashMap<String, Object> map) {
		 System.err.println("---这是账号密码验证-------------");
		//获取数据
		String text = (String)map.get("text");
		String pwd = (String)map.get("pwd");
		//创建Wrapper对象 *注意数据库字段名
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		wrapper.eq("uPwd", pwd).and(i->i.eq("uPhone", text).or().eq("uEmail", text));
		//查询
		User user=userService.getOne(wrapper);
		//判断是否存在
		if(user == null){
			return R.ok(null);
		}else {
			return R.ok(user.getUID());
		}
	}

	/**
	 * 验证email是否被注册
	 */
	@PostMapping("/isEmail")
	public Boolean isEmail(@RequestBody HashMap<String, Object> map) {
		System.err.println("---这是验证email是否被注册-------------");
		String email=(String)map.get("email");
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		wrapper.eq("uEmail", email);
		//判断email是否已经注册，没有为true 有则false
		boolean isEmail = userService.getOne(wrapper) == null;
		System.out.println(isEmail);
		return isEmail;
	}

	/**
	 * 验证邮箱并注册用户
	 */
	@PostMapping("/getNewUser")
	public R newUser(@RequestBody(required=false) Map<String, Object> map) {
		 System.err.println("---这是验证邮箱和注册用户-------------");
		@SuppressWarnings("unchecked")
		Map<String, Object> newUser = (Map<String, Object>)map.get("newUser");
		//验证email是否被注册
		String email=(String)newUser.get("email");
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		wrapper.eq("uEmail", email).last("LIMIT 1");
		boolean isEmail = userService.getOne(wrapper) == null;//没注册为true 已注册则false
		//进行判断
		Integer userId = null;
		if (isEmail) {
			User user = new User();
			user.setUName((String)newUser.get("uName"));
			user.setUSex(Integer.parseInt(newUser.get("uSex").toString()));
			user.setUEmail((String)newUser.get("uEmail"));
			user.setUPwd((String)newUser.get("uPwd"));
			boolean isSave= userService.save(user);
			//返回id
			userId=isSave?user.getUID():null;
			return R.ok(userId);
		}else {
			return R.ok(userId);
		}
	}

	@PostMapping("/getNewUser2")
	public R newUser2(@RequestParam("uName")String uName,
					  @RequestParam("uSex")String uSex,
					  @RequestParam("uEmail")String uEmail,
					  @RequestParam("uPwd")String uPwd) {
		System.err.println("---这是验证邮箱和注册用户-------------");
		@SuppressWarnings("unchecked")
		//验证email是否被注册
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		wrapper.eq("uEmail", uEmail).last("LIMIT 1");
		boolean isEmail = userService.getOne(wrapper) == null;//没注册为true 已注册则false
		//进行判断
		Integer userId = null;
		if (isEmail) {
			User user = new User();
			user.setUName(uName);
			user.setUSex(Integer.parseInt(uSex));
			user.setUEmail(uEmail);
			user.setUPwd(uPwd);
			boolean isSave= userService.save(user);
			//返回id
			userId=isSave?user.getUID():null;
			return R.ok(userId);
		}else {
			return R.ok(userId);
		}
	}

	/**
	 * 按id查找用户
	 */
	@GetMapping("/getUser/{id}")
	public R getUserAsId(@PathVariable Integer id) {
		System.err.println("--按id查找用户----");
		User user=userService.getById(id);
//		System.err.println(id);
		return R.ok(user);
	}

	/**
	 * 更改用户头像图片，将图片保存到指定位置
	 */
	@PostMapping("/updateAvatar")
	public R uploadImg(@RequestParam("uID")Integer uID, HttpServletRequest req){
		System.err.println("---更改用户图片，将图片保存到指定位置----");
		//存储数据
		FileMethod fileMethod=new FileMethod();
		String respFileName=fileMethod.uploadFile(req);
		//保存更新的图片
		userService.updateUImg(uID,respFileName);
		return R.ok(respFileName);
	}

	/**
	 * 更改用户消息
	 */
	@PostMapping("/updateUser")
	public R updateUser(@RequestBody Map<String, Object> map) {
		System.err.println("---更改用户消息----");
		//接收用户更改信息
		boolean isOk = false;
		if (map!=null) {
			Map<String, Object> newUser = (Map<String, Object>)map.get("userData");
			User user=new User();
			user.setUID((int)newUser.get("uid"));
			user.setUName((String)newUser.get("uname"));
			user.setUSex((int)newUser.get("usex"));
			user.setAutograph((String)newUser.get("autograph"));
			user.setUEmail((String)newUser.get("uemail"));
			user.setUPwd((String)newUser.get("upwd"));
			user.setUAvatar((String)newUser.get("uavatar"));

			isOk=userService.updateById(user);
		}
		return R.ok(isOk);
	}
	/**
	 * 删除帖子（只删除数据库信息
	 */
	@PostMapping("/delUserByuID")
	public R delStick(@RequestParam("uID")Integer uID){
		return R.ok(userService.removeById(uID));
	}
}

