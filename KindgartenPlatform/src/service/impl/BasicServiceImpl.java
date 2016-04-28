package service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import net.sf.json.JSONObject;
import service.IBasicService;
import util.DateUtils;
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
	private IHomeWorkDao homeworkDao;
	private IStudyDao studyDao;

	@Override
	public JSONObject login(User user) throws Exception {
		// TODO Auto-generated method stub
		// 获取user数据
		List<User> lstUser = userDao.queryEntitysByPropertys(new String[] {
				"phoneNumber", "password", "type" }, user.getPhoneNumber(),
				user.getPassword(), user.getType());
		JSONObject json = new JSONObject();
		// 判断是否存在
		if (lstUser != null && lstUser.size() > 0) {
			json.put("status", "1");
			// 获取class 数据
			String hql = "select c from ClassUser cu , Class c where cu.classId = c.id and cu.userId = ?";
			@SuppressWarnings("unchecked")
			List<Class> lstClass = classDao.createQuery(hql,
					lstUser.get(0).getId()).list();
			if (lstClass != null && lstClass.size() > 0) {
				json.put("classes", lstClass);
			}
			json.put("userId", lstUser.get(0).getId());
			json.put("userName", lstUser.get(0).getName());
		} else {
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
		homeworkDao.save(homework);
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
					hql = "select h from Homework h where classId = ? order by date desc";
					if (classId != null && !classId.isEmpty() && page != null
							&& !page.isEmpty() && pageNum != null
							&& !pageNum.isEmpty()) {
						List<Homework> lstHomework = homeworkDao
								.createQuery(hql, Long.valueOf(classId))
								.setFirstResult(
										Integer.valueOf(page)
												* Integer.valueOf(pageNum))
								.setMaxResults(Integer.valueOf(pageNum)).list();
						if (lstHomework != null && lstHomework.size() > 0) {
							json1.put("homework", lstHomework);
						}
					}

				}
				// 教师,园长权限
				if (type.equals("2") || type.equals("1")) {
					if (type.equals("2")) {
						hql = "select c.name,h.content,h.date from Homework h ,ClassUser cu,Class c  where h.classId = cu.classId and h.classId = c.classId and cu.userId = ? and h.date =? order by h.classId ";
					} else {
						hql = "select c.name,h.content,h.date from Homework h ,Class c  where  h.classId = c.classId and cu.userId = ? and h.date = ? order by h.classId ";
					}
					String userId = json.getString("userId");
					String date = json.getString("date");
					if (userId != null && !userId.isEmpty() && date != null
							&& !date.isEmpty()) {
						List list = homeworkDao.createQuery(
								hql,
								Long.valueOf(userId),
								DateUtils.parseStringToDate(date,
										DateUtils.YYYY_MM_DD_WITN_HYPHEN))
								.list();
						if (list != null && list.size() > 0) {
							json1.put("homework", list);
						}
					}
				}
			}
		}
		return json1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject queryTemperatureInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String hql = "";
		Query query = null;
		if (json != null) {
			String type = json.getString("type");
			String userId = json.getString("userId");
			String page = json.getString("page");
			String pageNum = json.getString("pageNum");
			String date = json.getString("date");
			String classId = json.getString("classId");
			if (type != null) {
				// 家长权限
				if (type.equals("3")) {
					hql = "select t from Temperature t where childId =? order by t.date desc";
					if (userId != null && !userId.isEmpty() && page != null
							&& !page.isEmpty() && pageNum != null
							&& !pageNum.isEmpty()) {
						query = temperatureDao
								.createQuery(hql, Long.valueOf(userId))
								.setFirstResult(
										Integer.valueOf(page)
												* Integer.valueOf(pageNum))
								.setMaxResults(Integer.valueOf(pageNum));
					}
				} else {
					hql = "select t from Temperature t,ClassUser cu  "
							+ " where t.childId = cu.userId and cu.classId = ? and  date =? order by t.id desc";
					if (classId != null && !classId.isEmpty() && date !=null && !date.isEmpty() && page != null
							&& !page.isEmpty() && pageNum != null
							&& !pageNum.isEmpty()) {
						query = temperatureDao.createQuery(hql, Long.valueOf(classId),DateUtils.parseStringToDate(date,
								DateUtils.YYYY_MM_DD_WITN_HYPHEN));
					}
				}
				if(query !=null){
					List<Temperature> lstTemperature = query.list();
					if(lstTemperature !=null && lstTemperature.size()>0){
						json1.put("temp", lstTemperature);
					}
				}
				

			}
		}
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

}
