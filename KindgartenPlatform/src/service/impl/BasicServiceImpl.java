package service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import service.IBasicService;
import bean.Class;
import bean.User;
import dao.IClassDao;
import dao.IUserdao;

public class BasicServiceImpl implements IBasicService {
	private IUserdao userDao;
	private IClassDao classDao;

	@Override
	public JSONObject login(User user) throws Exception {
		// TODO Auto-generated method stub
		// 获取user数据
		List<User> lstUser = userDao.queryEntitysByPropertys(
				new String[] { "phoneNumber,password" }, user.getPhoneNumber(),
				user.getPassword());
		JSONObject json = new JSONObject();
		// 判断是否存在
		if (lstUser != null && lstUser.size() > 0) {
			json.put("status", "1");
			// 获取class 数据
			String hql = "select Class from ClassUser cu , Class c where cu.classId = c.id and cu.userId = ?";
		    @SuppressWarnings("unchecked")
			List<Class> lstClass=classDao.createQuery(hql, lstUser.get(0).getId()).list();
		    if(lstClass!=null && lstClass.size()>0){
		    	json.put("classes", lstClass);
		    }
		}else{
			json.put("status", "0");
		}
		return json;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		// 取出user数据
		// 判断是否存在
		// 如果不存在就注册
		return false;
	}



	public IUserdao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserdao userDao) {
		this.userDao = userDao;
	}

	public IClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(IClassDao classDao) {
		this.classDao = classDao;
	}

}
