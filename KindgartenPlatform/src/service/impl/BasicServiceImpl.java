package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import net.sf.json.JSONObject;
import service.IBasicService;
import util.DateUtils;
import bean.Class;
import bean.ClassUser;
import bean.Homework;
import bean.Study;
import bean.Subject;
import bean.Temperature;
import bean.User;
import dao.IClassDao;
import dao.IClassUserDao;
import dao.IHomeWorkDao;
import dao.IStudyDao;
import dao.ISubjectDao;
import dao.ITemperatureDao;
import dao.IUserdao;

public class BasicServiceImpl implements IBasicService {
	private IUserdao userDao;
	private IClassDao classDao;
	private ITemperatureDao temperatureDao;
	private IHomeWorkDao homeworkDao;
	private IStudyDao studyDao;
	private ISubjectDao subjectDao;
	private IClassUserDao classUserDao;

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject login(User user) throws Exception {
		// TODO Auto-generated method stub
		// 获取user数据
		List<User> lstUser = userDao.queryEntitysByPropertys(new String[] {
				"phoneNumber", "password", "type" }, user.getPhoneNumber(),
				user.getPassword(), user.getType());
		// 获取科目详情
		List<Subject> lsyUsbSubject = subjectDao.getAll();
		// 获取所有user
		String hql1 ="select u from User u where u.type !=0";
		List<User> lstUser1 = userDao.createQuery(hql1).list();
		JSONObject json = new JSONObject();
		// 判断是否存在
		if (lstUser != null && lstUser.size() > 0) {
			json.put("status", "1");
			// 获取class 数据
			String hql = "select c from ClassUser cu , Class c where cu.classId = c.id and cu.userId = ?";
			List<Class> lstClass =null;
			if(user.getType() == 1){
				lstClass=classDao.getAll();
			}else{
			lstClass= classDao.createQuery(hql,
					lstUser.get(0).getId()).list();
			}
			if (lstClass != null && lstClass.size() > 0) {
				json.put("classes", lstClass);
			}
			json.put("userId", lstUser.get(0).getId());
			json.put("userName", lstUser.get(0).getName());
			json.put("userPhoto", lstUser.get(0).getPhoto());
			json.put("subject", lsyUsbSubject);
			json.put("users", lstUser1);
		} else {
			json.put("status", "0");
		}
		return json;
	}

	@Override
	public JSONObject saveTemperature(Temperature temp) throws Exception {
		// TODO Auto-generated method stub
		List<Temperature> lstTemperature = temperatureDao
				.queryEntitysByPropertys(new String[] { "childId", "date" },
						temp.getChildId(), temp.getDate());
		if (lstTemperature != null && lstTemperature.size() > 0) {
			Temperature temp1 = lstTemperature.get(0);
			temp1.setRemark(temp.getRemark());
			temp1.setTemperature(temp.getTemperature());
			temp1.setTeacherId(temp.getTeacherId());
			temperatureDao.update(temp1);
		} else {
			temperatureDao.save(temp);
		}
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}

	@Override
	public JSONObject saveHomework(Homework homework) throws Exception {
		// TODO Auto-generated method stub
		List<Homework> lstHomework = homeworkDao.queryEntitysByPropertys(
				new String[] { "classId", "date" }, homework.getClassId(),
				homework.getDate());
		if (lstHomework != null && lstHomework.size() > 0) {
			Homework homework2 = lstHomework.get(0);
			homework2.setContent(homework.getContent());
			homework2.setTeacherId(homework.getTeacherId());
			homeworkDao.update(homework2);
		} else {
			homeworkDao.save(homework);
		}
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject saveStudy(Study study) throws Exception {
		// TODO Auto-generated method stub
		// List<Study> s = studyDao.queryEntitysByPropertys(new String[] {
		// "classId", "subjectId", "date" }, study.getClassId(),
		// study.getSubjectId(), study.getDate());
		String hql = "select o from Study o  where  o.classId=? and o.subjectId=? and o.date=?";
		List<Study> s = studyDao.createQuery(hql, study.getClassId(),
				study.getSubjectId(), study.getDate()).list();
		if (s != null && s.size() > 0) {
			Study stu = s.get(0);
			stu.setContent(study.getContent());
			stu.setTeacherId(study.getTeacherId());
			studyDao.update(stu);
		} else {
			studyDao.save(study);
		}
		JSONObject json = new JSONObject();
		json.put("status", "1");
		return json;
	}

	@Override
	public JSONObject queryStudyInfo(Long classId, Date date) throws Exception {
		// TODO Auto-generated method stub
		String hql = "select su.name,st.content,st.date from Study st , Subject su where st.subjectId = su.id and st.classId = ? and st.date = ? ";
		@SuppressWarnings("rawtypes")
		List list = studyDao.createQuery(hql, classId, date).list();
		JSONObject json = new JSONObject();
		json.put("status", "1");
		if (list != null && list.size() > 0) {
			json.put("study", list);
		}
		return json;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONObject queryHomeworkInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String hql = "";
		if (json != null) {
			String type = json.getString("type");
			if (type != null) {
				// 家长权限
				if (type.equals("3")) {
					String classId = json.getString("classId");
					String page = json.getString("page");
					String pageNum = json.getString("pageNum");
					String lastDate = json.getString("lastDate");
					hql = "select h from Homework h where h.classId = ? and h.date < ? order by h.date desc";
					if (classId != null && !classId.isEmpty() && page != null
							&& !page.isEmpty() && pageNum != null
							&& !pageNum.isEmpty()) {
						List<Homework> lstHomework = homeworkDao
								.createQuery(
										hql,
										Long.valueOf(classId),
										DateUtils
												.parseStringToDate(
														lastDate,
														DateUtils.YYYY_MM_DD_WITN_HYPHEN))
								.setFirstResult(
										Integer.valueOf(page)
												* Integer.valueOf(pageNum))
								.setMaxResults(Integer.valueOf(pageNum)).list();
						if (lstHomework != null && lstHomework.size() > 0) {
							List<String[]> list = new ArrayList<String[]>();
							for (Homework homework : lstHomework) {
								String[] a = new String[2];
								a[0] = homework.getContent();
								a[1] = DateUtils.getDateFromStr(
										homework.getDate(),
										DateUtils.YYYY_MM_DD_WITN_HYPHEN);
								list.add(a);
							}
							json1.put("homework", list);
						}
					}

				}
				// 教师,园长权限
				if (type.equals("2") || type.equals("1")) {
					if (type.equals("2")) {
						hql = "select c.name,h.content,h.date from Homework h ,ClassUser cu,Class c  where h.classId = cu.classId and h.classId = c.id and cu.userId = ? and h.date =? order by h.classId ";
					} else {
						hql = "select c.name,h.content,h.date from Homework h ,Class c  where  h.classId = c.id and h.date = ? order by h.classId ";
					}
					String userId = json.getString("userId");
					String date = json.getString("date");
					if (userId != null && !userId.isEmpty() && date != null
							&& !date.isEmpty()) {
						List list = null;
						if(type.equals("2")){
							list=	homeworkDao.createQuery(
									hql,
									Long.valueOf(userId),
									DateUtils.parseStringToDate(date,
											DateUtils.YYYY_MM_DD_WITN_HYPHEN))
									.list();
						}else{
							list=	homeworkDao.createQuery(
									hql,
									Long.valueOf(userId))
									.list();
						}
					
						if (list != null && list.size() > 0) {
							json1.put("homework", list);
						}
					}
				}
			}
		}
		return json1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONObject queryTemperatureInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String hql = "";
		Query query = null;
		if (json != null) {
			String type = json.getString("type");
			if (type != null) {
				// 家长权限
				if (type.equals("3")) {
					String userId = json.getString("userId");
					String page = json.getString("page");
					String pageNum = json.getString("pageNum");
					String lastDate = json.getString("lastDate");
					hql = "select t,u from Temperature t,User u  where t.childId = u.id and t.childId =? and date <? order by t.date desc";
					if (userId != null && !userId.isEmpty() && page != null
							&& !page.isEmpty() && pageNum != null
							&& !pageNum.isEmpty()) {
						query = temperatureDao
								.createQuery(hql, Long.valueOf(userId),DateUtils.parseStringToDate(
										lastDate, DateUtils.YYYY_MM_DD_WITN_HYPHEN))
								.setFirstResult(
										Integer.valueOf(page)
												* Integer.valueOf(pageNum))
								.setMaxResults(Integer.valueOf(pageNum));
					}
				} else if(type.equals("1")||type.equals("2")) {
					String date = json.getString("date");	
					String classId = json.getString("classId");
					hql = "select t,u from Temperature t,ClassUser cu,User u   "
							+ " where t.childId = cu.userId and t.childId = u.id  and cu.classId = ? and  t.date =? order by t.id desc";
					if (classId != null && !classId.isEmpty() && date != null
							&& !date.isEmpty() ) {
						query = temperatureDao.createQuery(hql, Long
								.valueOf(classId), DateUtils.parseStringToDate(
								date, DateUtils.YYYY_MM_DD_WITN_HYPHEN));
					}
				}
				if (query != null) {
					List list = query.list();
					if (list != null && list.size() > 0) {
						json1.put("temp", list);
					}
				}

			}
		}
		return json1;
	}
	@Override
	public JSONObject webLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		if(user !=null){
			List<User> lstUser = userDao.queryEntitysByPropertys(new String[] {
					"name", "password", "type" }, user.getName(),
					user.getPassword(), user.getType());
			if(lstUser !=null && lstUser.size()>0){
				json.put("status", "1");
			}else{
				json.put("status", "0");
			}
		}else{
			json.put("status", "0");
		}
		return json;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject queryClassesInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		List<Class> lstClass = classDao.getAll();
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String type = json.getString("type");
		if(type.equals("1")){// add
		
		}else if(type.equals("2")){//update
			String userId = json.getString("userId");
			User u  = userDao.findUniqueBy("id", Long.valueOf(userId));
			json1.put("user", u);
			String hql = "select c from ClassUser cu , Class c where cu.classId = c.id and cu.userId = ? ";
			List<Class> lstClass1 = classDao.createQuery(hql, Long.valueOf(userId)).list();
			if(lstClass1 !=null && lstClass1.size()>0){
				json1.put("myClasses", lstClass1);
			}
		}
		if(lstClass!=null && lstClass.size()>0){
			json1.put("classes", lstClass);
		}
		return json1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject queryAllUsersInfo() throws Exception {
		// TODO Auto-generated method stub
		String hql ="select u from User u where u.type !=0";
		List<User> lstUser = userDao.createQuery(hql).list();
		JSONObject json = new JSONObject();
		json.put("status", "1");
		if(lstUser!=null && lstUser.size()>0){
			json.put("users", lstUser);
		}
		return json;
	}
	@Override
	public JSONObject queryAllSubjectInfo() throws Exception {
		// TODO Auto-generated method stub
		List<Subject> lstSubject = subjectDao.getAll();
		JSONObject json = new JSONObject();
		json.put("status", "1");
		if(lstSubject!=null && lstSubject.size()>0){
			json.put("subjects", lstSubject);
		}
		return json;
	}

	@Override
	public JSONObject updateUserPassword(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String userId = json.getString("userId");
		String newPas = json.getString("newPas");
		User u = userDao.findUniqueBy("id", Long.valueOf(userId));
		if(u !=null){
			u.setPassword(newPas);
			userDao.update(u);
		}
		return json1;
	}

	@Override
	public JSONObject updateUserHeaderImage(Long userId,String photo) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		User u =userDao.findUniqueBy("id", userId);
		if(u !=null){
			u.setPhoto(photo);
			userDao.update(u);
		}
		return json1;
	}
	
	@Override
	public JSONObject saveOrUpdateUser(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		String status = "1";
		String phoneNumber = json.getString("phoneNumber");
		String name = json.getString("name");
		String doType = json.getString("doType");
		String type = json.getString("type");
		String pas = json.getString("pas");
		String[] classes = json.getString("classes").split(",");
		if(doType.equals("1")){
			User u = userDao.findUniqueBy("phoneNumber", Long.valueOf(phoneNumber));
			if(u!=null ){
				status = "2";
			}else{
				User user = new User();
				user.setPhoneNumber(Long.valueOf(phoneNumber));
				user.setName(name);
				user.setPassword(pas);
				user.setType(Short.valueOf(type));
				userDao.save(user);
				if(classes!=null && classes.length>0){
					for(int i =0;i<classes.length;i++){
						if(classes[i]!=null && classes[i]!=""){
							ClassUser cu = new ClassUser();
							cu.setUserId(user.getId());
							cu.setClassId(Long.valueOf(classes[i]));
							classUserDao.save(cu);
						}
					}
				}
			}
		}else if(doType.equals("2")){
			String id =json.getString("userId");
			User u = userDao.findUniqueBy("id", Long.valueOf(id));
			if(u==null){
				status = "3";
			}else{
				u.setPhoneNumber(Long.valueOf(phoneNumber));
				u.setName(name);
				u.setPassword(pas);
				u.setType(Short.valueOf(type));
				userDao.update(u);
				List<ClassUser> lstClassUser = classUserDao.findBy("userId", u.getId());
				if(lstClassUser!=null && lstClassUser.size()>0){
					for(ClassUser cu : lstClassUser){
						classUserDao.remove(cu);
					}
				}
				if(classes!=null && classes.length>0){
					for(int i =0;i<classes.length;i++){
						if(classes[i]!=null && classes[i]!=""){
							ClassUser cu = new ClassUser();
							cu.setUserId(u.getId());
							cu.setClassId(Long.valueOf(classes[i]));
							classUserDao.save(cu);
						}
					}
				}
			}
			
		}
		json1.put("status", status);
		//List<user> 
		return json1;
	}

	@Override
	public JSONObject deleteUser(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		String userId = json.getString("userId");
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		userDao.removeById(Long.valueOf(userId));
		return json1;
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

	public IHomeWorkDao getHomeworkDao() {
		return homeworkDao;
	}

	public void setHomeworkDao(IHomeWorkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}

	public IStudyDao getStudyDao() {
		return studyDao;
	}

	public void setStudyDao(IStudyDao studyDao) {
		this.studyDao = studyDao;
	}

	public ISubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(ISubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public IClassUserDao getClassUserDao() {
		return classUserDao;
	}

	public void setClassUserDao(IClassUserDao classUserDao) {
		this.classUserDao = classUserDao;
	}

    













}
