package com.cg.blog.controller.admin;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cg.blog.entity.Blogger;
import com.cg.blog.service.BloggerService;
import com.cg.blog.util.ResponseUtil;

import com.cg.blog.util.MD5Util;

import com.cg.blog.util.DateUtil;
import com.cg.blog.util.PathUtil;
/**
 * 博主信息管理控制层(后台)
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="/admin/blogger")
public class BloggerAdminController {
	@Autowired
	private BloggerService bloggerService;
	/**
	 * 获取博主信息
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getBloggerData(HttpServletResponse response)throws Exception{
		Blogger blogger = bloggerService.getBloggerData();
		
		String jsonStr = JSONObject.toJSONString(blogger);
		
		JSONObject object = JSONObject.parseObject(jsonStr);
		ResponseUtil.write(response, object);
		return null;
	}
	/**
	 * 判断是否有图片,有就更新
	 * @param imageFile
	 * @param blogger
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String saveBlogger(@RequestParam(value = "imageFile",required = false) MultipartFile imageFile, Blogger blogger,
            HttpServletResponse response)throws Exception{
		  //判断是否有上图片 有就更新
        if(!imageFile.isEmpty()){
            String filePath = PathUtil.getRootPath(); //获取服务器根路径
            String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "/src/main/webapp/static/userImages/" + imageName));
            blogger.setImageName(imageName);
        }
        int resultTotal = bloggerService.update(blogger);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
	}
	/**
	 * 更新博主密码
	 * @param blogger
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "modtifyPassword",method = RequestMethod.POST)
    public String modityBloggerPassword(Blogger blogger,HttpServletResponse response) throws Exception {
        //加密
        String newPassword = MD5Util.md5(blogger.getPassword(),"admin");
        blogger.setPassword(newPassword);
        int resultTotal = bloggerService.update(blogger);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}
