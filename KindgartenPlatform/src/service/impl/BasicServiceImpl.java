package service.impl;

import service.IBasicService;
import bean.User;

public class BasicServiceImpl implements IBasicService {

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		// 获取user数据
		// 判断是否存在
		// 验证密码是否正确
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		// 取出user数据
		// 判断是否存在
		// 如果不存在就注册
		return false;
	}

}
