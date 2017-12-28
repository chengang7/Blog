package com.cg.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
/**
 * Response工具类
 * @author root1
 * @date 2017年12月25日
 */
public class ResponseUtil {
	/**
	 * 向response对象写入数据
	 * @param response
	 * @param obj
	 * @throws Exception
	 */
	 public static void write(HttpServletResponse response, Object obj)throws Exception{
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        out.println(obj.toString());
	        out.flush();
	        out.close();
	    }
}
