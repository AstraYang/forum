package com.forum.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.forum.mapper.ReplyMapper;
import com.forum.model.Reply;
import com.forum.service.ReplyService;
import com.forum.service.ReplyVoService;
import com.forum.service.StickService;
import com.forum.vo.ReplyVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    ReplyService replyService;
    @Resource
    ReplyVoService replyVoService;
    @Resource
    StickService StickService;

    /**
     * 根据主贴ID获取回复贴（里面包含回复贴用户信息
     */
    @GetMapping("/getReplies/{mID}")
    public R getReplies(@PathVariable Integer mID){
        System.err.println("--根据mID获取回复贴----");
        //获取回复贴
        List<ReplyVo> replies = replyVoService.getReplyAndUser(mID);
        //装上数据
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("replies",replies);
        //响应数据
        return R.ok(resultMap);
    }

    /**
     * 根据主贴ID获取回复贴数量（并且保存记录到主贴
     */
    @GetMapping("/getReplyCountAsMID/{mID}")
    public R getReplyCountAsMID(@PathVariable Integer mID) {
        System.err.println("--获取回复贴数量----");
        //获得回复数量
        Integer count = replyService.getReplyCountAsMID(mID);
        //保存主贴回复数量
        replyService.saveReplyCount(mID,count);
        return R.ok(count);
    }

    /**
     * 获取该用户主贴的回复帖（里面包含回复贴用户信息
     */
    @GetMapping("/getUMReplies/{uID}")
    public R getReply(@PathVariable Integer uID){
        System.err.println("--获取该用户帖子的回复帖----");
        //获取回复贴
        List<ReplyVo> uReplies= replyVoService.getReplyInUStick(uID);
        //装上数据
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("uReplies",uReplies);
        //响应数据
        return R.ok(resultMap);
    }

    /**
     * 添加回复贴
     */
    @PostMapping("/addReply")
    public R addReply(@RequestParam("mID")Integer mID,
                      @RequestParam("uID")Integer uID,
                      @RequestParam("rContent")String rContent,
                      @RequestParam("mReplies")Integer mReplies){
        //将数据存放到Reply
        Reply reply = new Reply();
        reply.setMID(mID);
        reply.setUID(uID);
        reply.setRContent(rContent);
        //保存记录
        StickService.addReplies(mReplies,mID);
        //执行并返回
        return R.ok(replyService.save(reply));
    }

//    简单点赞
    /**
     * 点赞
     */
    @GetMapping("/addRLike/{rLike}/{rID}")
    public R addRLike(@PathVariable("rLike")Integer rLike,@PathVariable("rID")Integer rID){
        return R.ok(replyService.addRLike(rLike,rID));
    }
}
