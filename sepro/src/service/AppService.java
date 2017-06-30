package service;

import model.user;

public interface AppService {

	
	/* 
	 * 登录 
	 * 参数1可以是username，email或phone，参数2是密码
	 * 如果匹配成功，返回该user，用户不存在或密码不正确返回null
	 */
	public user login(String username, String password);
	
	
	/*
	 * 注册
	 * 参数是user,是action临时创建的user对象，包含username，phone，password
	 * 用户名已存在返回-1，phone已存在返回-2
	 * 用户名不合法返回-3，phone不合法返回-4，密码不合法返回-5(判断是否合法可以先不实现）
	 * 注册成功返回1
	 * 
	 */
	public int register(user user);
	
	
}
