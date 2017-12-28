package com.cg.blog.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
/**
 * 博主实体
 * @author root1
 *
 */
@Getter@Setter
public class Blogger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 博主信息
	 */
	private String profile;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 博主签名
	 */
	private String sign;
	
	/**
	 * 博主头像路径
	 */
	private String imageName;
	
	public Blogger () {
		
	}
	public Blogger(Integer id, String userName, String password, String profile, String nickName, String sign,
			String imageName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.profile = profile;
		this.nickName = nickName;
		this.sign = sign;
		this.imageName = imageName;
	}


	@Override
	public String toString() {
		return "Blogger [id=" + id + ", userName=" + userName + ", password=" + password + ", profile=" + profile
				+ ", nickName=" + nickName + ", sign=" + sign + ", imageName=" + imageName + "]";
	}


	
}
