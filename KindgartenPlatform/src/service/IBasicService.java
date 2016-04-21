package service;

import bean.User;

/**
 * 系统基础操作处理（登录、注册等）
 * @author Administrator
 *
 */
public interface IBasicService {
	/**
	 * 登录判断
	 * @param user
	 * @return true：登录成功 false:用户不存在
	 */
	public boolean login(User user);
	/**
	 * 注册判断
	 * @param user
	 * @return true :注册成功 false：用户已存在
	 */
	public boolean register(User user);

}
