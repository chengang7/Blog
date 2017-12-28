package com.cg.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.cg.blog.entity.Comment;
import com.cg.blog.service.BlogService;
import com.cg.blog.service.CommentService;

import com.cg.blog.entity.Blog;
import com.cg.blog.util.ResponseUtil;
/**
 * 前台评论控制器
 * @author root1
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private BlogService blogService;
	/**
	 * 评论更新或者增加
	 * @param comment
	 * @param imageCode
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="save")
	public String save(Comment comment,@RequestParam("imageCode")String imageCode, //前台传来的验证码
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception{
		//获取session中正确的验证码，验证码产生后会存到session中的
		String sRand = (String) session.getAttribute("sRand");
		JSONObject result = new JSONObject();
		//执行记录数
		int resultTotal = 0;
		 if(!imageCode.equals(sRand)){
	            result.put("success",false);
	            result.put("errorInfo","验证码有误");
	        }else{
	            //获取评论者ip
	            String userIp = request.getRemoteAddr();
	            comment.setUserIp(userIp);
	            if(comment.getId() == null){
	                resultTotal = commentService.saveComment(comment); //添加评论
	                Blog blog = blogService.getById(comment.getBlog().getId()); //更新一下博客的评论次数
	                blog.setReplyHit(blog.getReplyHit() + 1);
	                blogService.updateBlog(blog);
	            }else{
	                //更新操作
	            }
	        }
	        if(resultTotal > 0) {
	            result.put("success", true);
	        }
	        ResponseUtil.write(response, result);
	        return null;
	    }
}

