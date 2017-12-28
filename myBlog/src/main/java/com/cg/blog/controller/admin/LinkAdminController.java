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
import com.cg.blog.service.LinkService;

import com.cg.blog.entity.Link;
import com.cg.blog.entity.PageBean;
import com.cg.blog.util.ResponseUtil;
/**
 * 友情链接控制层
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="/admin/link")
public class LinkAdminController {
	@Autowired
	private LinkService linkService;
	
	/**
	 * 分页显示
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
    public String listByPage(
            @RequestParam("page") String page,
            @RequestParam("rows") String rows,
            HttpServletResponse response
            ) throws Exception {
        PageBean<Link> pageBean = new PageBean<Link>(Integer.parseInt(page),Integer.parseInt(rows));
        pageBean=linkService.listByPage(pageBean);
        String jsonStr = JSONObject.toJSONString(pageBean.getResult());
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        JSONObject result = new JSONObject();
        result.put("total",pageBean.getTotal());
        result.put("rows",jsonArray);
        ResponseUtil.write(response,result);
        return null;
    }
	/**
	 * 新增or修改友情链接
	 * @param link
	 * @param response
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value = "save",method = RequestMethod.POST)
	    public String saveLink(Link link,HttpServletResponse response) throws Exception {

	        int totalCount = 0;
	        //修改操作
	        if(link.getId() != null){
	            totalCount = linkService.updateLink(link);
	        }else{
	        // 新增操作
	            totalCount = linkService.addLink(link);
	        }
	        JSONObject result = new JSONObject();
	        if(totalCount > 0){
	            result.put("success",true);
	        }else {
	            result.put("success",false);
	        }
	        ResponseUtil.write(response,result);
	        return  null;
	 }
	 /**
	  * 删除友情链接
	  * @param ids
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "delete",method = RequestMethod.POST)
	    public String deleteLink(String ids,HttpServletResponse response) throws Exception {
	        String[] idArray = ids.split(",");
	        for (int i = 0; i < idArray.length; i++) {
	            linkService.deleteLink(Integer.parseInt(idArray[i]));
	        }
	        JSONObject result = new JSONObject();
	        result.put("success",true);
	        ResponseUtil.write(response,result);
	        return null;
	    }
}
	 
