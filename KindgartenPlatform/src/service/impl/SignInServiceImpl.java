package service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import service.ISignInService;
import bean.User;
import dao.IUserdao;

public class SignInServiceImpl implements ISignInService {
	private IUserdao userDao;
	@Override
	public JSONObject getStudentInfoByClassId(Long classId) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("status", "1");
		String hql ="select u from ClassUser cu , User u where cu.userId = u.id and u.type = 3 and cu.classId = ?";
	    @SuppressWarnings("unchecked")
		List<User> lstUser=userDao.createQuery(hql, classId).list();
	    if(lstUser!=null && lstUser.size()>0){
	    	json.put("users", lstUser);
	    }
		return json;
	}
	public IUserdao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserdao userDao) {
		this.userDao = userDao;
	}

}
