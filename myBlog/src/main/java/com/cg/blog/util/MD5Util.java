package com.cg.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;
/**
 * MD5加密工具类
 * @author root1
 * @date 2017年12月25日
 */
public class MD5Util {
	/**
	 * 使用Shrio中的MD5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
        //Md5Hash是Shiro中的一个方法
        return new Md5Hash(str, salt).toString();
    }
}
