package service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import service.IBasicService;
import bean.Class;
import bean.Homework;
import bean.Study;
import bean.Temperature;
import bean.User;
import dao.IClassDao;
import dao.IHomeWorkDao;
import dao.IStudyDao;
import dao.ITemperatureDao;
import dao.IUserdao;

public class BasicServiceImpl implements IBasicService {
	private IUserdao userDao;
	private IClassDao classDao;
    private ITemperatureDao temperatureDao;
    private IHomeWorkDao homeWorkDao;
    private IStudyDao studyDao;
	@Override
	public JSONObject login(User user) throws Exception {
		// TODO Auto-generated method stub
		// 获取user数据
		List<User> lstUser = userDao.queryEntitysByPropertys(
				new String[] { "phoneNumber","password","type" }, user.getPhoneNumber(),
				user.getPassword(),user.getType());
		JSONObject json = new JSONObject();
		// 判断是否存在
		if (lstUser != null && lstUser.size() > 0) {
			json.put("status", "1");
			// 获取class 数据
			String hql = "select c from ClassUser cu , Class c where cu.classId = c.id and cu.userId = ?";
		    @SuppressWarnings("unchecked")
			List<Class> lstClass=classDao.createQuery(hql, lstUser.get(0).getId()).list();
		    if(lstClass!=null && lstClass.size()>0){
		    	json.put("classes", lstClass);
		    }
		    json.put("userId", lstUser.get(0).getId());
		}else{
			json.put("status", "0");
		}
		return json;
	}
	@Override
	public JSONObject saveTemperature(Temperature temp) throws Exception {
		// TODO Auto-generated method stub
		temperatureDao.save(temp);
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}
	
	@Override
	public JSONObject saveHomework(Homework homework) throws Exception {
		// TODO Auto-generated method stub
		homeWorkDao.save(homework);
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}
	@Override
	public JSONObject saveStudy(Study study) throws Exception {
		// TODO Auto-generated method stub
		studyDao.save(study);
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}
	
	@Override
	public JSONObject queryStudyInfo(Long classId, Date date) throws Exception {
		// TODO Auto-generated method stub
		String hql = "select su.name,st.content,st.date from Study st , Subject su wher st.subjectId = su.id and st.classId = ? and st.date = ? ";
	    @SuppressWarnings("rawtypes")
		List list=studyDao.createQuery(hql, classId,date).list();
	    JSONObject json = new JSONObject();
    	json.put("status", "1");
	    if(list !=null && list.size()>0){
	    	json.put("study",list);
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

	public ITemperatureDao getTemperatureDao() {
		return temperatureDao;
	}
	public void setTemperatureDao(ITemperatureDao temperatureDao) {
		this.temperatureDao = temperatureDao;
	}
	public IClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(IClassDao classDao) {
		this.classDao = classDao;
	}
	public IHomeWorkDao getHomeWorkDao() {
		return homeWorkDao;
	}
	public void setHomeWorkDao(IHomeWorkDao homeWorkDao) {
		this.homeWorkDao = homeWorkDao;
	}
	public IStudyDao getStudyDao() {
		return studyDao;
	}
	public void setStudyDao(IStudyDao studyDao) {
		this.studyDao = studyDao;
	}






}
