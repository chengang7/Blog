package com.cg.blog.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cg.blog.service.CommentService;

import com.cg.blog.entity.Comment;
import com.cg.blog.entity.PageBean;
import com.cg.blog.util.ResponseUtil;
/**
 * 博客访问控制层
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="admin/comment")
public class CommentAdminController {
	@Autowired
	private CommentService commentService;
	/**
	 * 评论分页显示
	 * @param page
	 * @param rows
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String listByPage(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "state", required = false) String state, HttpServletResponse response)
			throws Exception {
		PageBean<Comment> pageBean = new PageBean<Comment>(Integer.parseInt(page), Integer.parseInt(rows));
		pageBean.getMap().put("state", state);
		pageBean = commentService.listByPage(pageBean);
		JSONObject result = new JSONObject();
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String jsonStr = JSONObject.toJSONString(pageBean.getResult(), SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect);
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		result.put("total", pageBean.getTotal());
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 删除评论
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteComment(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idStr = ids.split(",");
		for (int i = 0; i < idStr.length; i++) {
			commentService.deleteComment(Integer.parseInt(idStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 回复评论
	 * @param ids
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "review")
	public String reviewComment(@RequestParam(value = "ids", required = false) String ids,
			@RequestParam(value = "state", required = false) String state, HttpServletResponse response)
			throws Exception {
		String[] idStr = ids.split(",");
		for (int i = 0; i < idStr.length; i++) {
			Comment comment = new Comment();
			comment.setId(Integer.parseInt(idStr[i]));
			comment.setState(Integer.parseInt(state));
			commentService.updateComment(comment);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
