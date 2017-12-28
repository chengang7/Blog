package com.cg.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blog.dao.CommentDao;
import com.cg.blog.service.CommentService;

import com.cg.blog.entity.Comment;
import com.cg.blog.entity.PageBean;
/**
 * CommentService组件类
 * @author cg
 * @date 2017年12月25日
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public PageBean<Comment> listByPage(PageBean<Comment> pageBean) {
        pageBean.getMap().put("start",pageBean.getStart());
        pageBean.getMap().put("end",pageBean.getEnd());
        pageBean.setResult(commentDao.listByPage(pageBean.getMap()));
        pageBean.setTotal(commentDao.getTotal(pageBean.getMap()));
        return pageBean;
    }


    public Long getTotal(Map<String, Object> map) {
        return commentDao.getTotal(map);
    }


    public Comment getById(Integer id) {
        return commentDao.getById(id);
    }


    public Integer saveComment(Comment comment) {
        return commentDao.saveComment(comment);
    }


    public Integer deleteComment(Integer id) {
        return commentDao.deleteComment(id);
    }


    public Integer updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }


    public Long deleteCommentByBlogId(Integer blogId) {
        return commentDao.deleteCommentByBlogId(blogId);
    }

    public List<Comment> getCommentData(Map<String, Object> map) {
        return commentDao.listByPage(map);
    }
}
