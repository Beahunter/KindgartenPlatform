package service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Query;

import service.ISignInService;
import util.DateUtils;
import bean.Cookbook;
import bean.Life;
import bean.SignIn;
import bean.User;
import dao.ICookbookDao;
import dao.ILifeDao;
import dao.ISignInDao;
import dao.IUserdao;

public class SignInServiceImpl implements ISignInService {
	private IUserdao userDao;
	private ISignInDao signInDao;
	private ILifeDao lifeDao;
	private ICookbookDao cookbookDao;

	@Override
	public JSONObject getStudentInfoByClassId(Long classId) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("status", "1");
		String hql = "select u from ClassUser cu , User u where cu.userId = u.id and u.type = 3 and cu.classId = ?";
		@SuppressWarnings("unchecked")
		List<User> lstUser = userDao.createQuery(hql, classId).list();
		if (lstUser != null && lstUser.size() > 0) {
			json.put("users", lstUser);
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject signIn(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		String childId = json.getString("childId");
		String type = json.getString("type");
		String photo = json.getString("photo");
		String remark = json.getString("remark");
		String teacherId = json.getString("teacherId");
		Date date = new Date();
		String hql = "select s from SignIn s where s.type = ? and s.childId =? and DATE_FORMAT(s.time,'%Y-%m-%d')  = ?";
		List<SignIn> lstSignIn = signInDao
				.createQuery(
						hql,
						Short.valueOf(type),
						Long.valueOf(childId),
						DateUtils.getDateFromStr(date,
								DateUtils.YYYY_MM_DD_WITN_HYPHEN)).list();
		if (lstSignIn != null && lstSignIn.size() > 0) {
			// 更新签到
			SignIn si = lstSignIn.get(0);
			si.setPhoto(photo);
			si.setRemark(remark);
			si.setTeacherId(Long.valueOf(teacherId));
			si.setTime(DateUtils.formateDate(date,
					DateUtils.YYYY_MM_DD_HH_MM_SS2));
			signInDao.update(si);
		} else {
			SignIn si = new SignIn();
			si.setChildId(Long.valueOf(childId));
			si.setPhoto(photo);
			si.setRemark(remark);
			si.setTeacherId(Long.valueOf(teacherId));
			si.setTime(DateUtils.formateDate(date,
					DateUtils.YYYY_MM_DD_HH_MM_SS2));
			si.setType(Short.valueOf(type));
			signInDao.save(si);
		}
		json1.put("status", "1");
		return json1;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JSONObject querySignInInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String hql = "";
		Query query = null;
		String type = json.getString("type");
		if (type != null) {
			if (type.equals("3")) {
				String userId = json.getString("userId");
				// String page = json.getString("page");
				String pageNum = json.getString("pageNum");
				String lastDate = json.getString("lastDate");
				hql = "select s,u from SignIn s ,User u where s.childId = u.id and s.time < ? and s.childId = ? order by s.time desc ";
				query = signInDao.createQuery(hql, lastDate,
						Long.valueOf(userId)).setMaxResults(
						Integer.valueOf(pageNum));
			} else if (type.equals("1") || type.equals("2")) {
				String date = json.getString("date");
				String classId = json.getString("classId");
				String signType = json.getString("signType");
				hql = "select s,u from SignIn s , User u,ClassUser cu  where s.childId = u.id and s.childId = cu.userId and DATE_FORMAT(s.time,'%Y-%m-%d')  = ? and s.type = ? and cu.classId = ? ";
				query = signInDao.createQuery(hql, date,
						Short.valueOf(signType), Long.valueOf(classId));
			}
			if (query != null) {
				List list = query.list();
				if (list != null && list.size() > 0) {
					json1.put("signInfo", list);
				}
			}
		}
		return json1;
	}

	@Override
	public JSONObject saveLifeInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String userId = json.getString("userId");
		String photo = json.getString("photo");
		String remark = json.getString("remark");
		Date date = new Date();
		Life life = new Life();
		life.setPhoto(photo);
		life.setRemark(remark);
		life.setTime(DateUtils
				.formateDate(date, DateUtils.YYYY_MM_DD_HH_MM_SS2));
		life.setUserId(Long.valueOf(userId));
		lifeDao.save(life);
		return json1;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JSONObject queryLifeInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String hql = "";
		Query query = null;
		String type = json.getString("type");
		String pageNum = json.getString("pageNum");
		String lastDate = json.getString("lastDate");
		if (type != null) {
			if (type.equals("1")) {
				hql = "select l,u  from Life l ,User u where l.userId = u.id and l.time < ? order by l.time desc";
				query = lifeDao.createQuery(hql, lastDate).setMaxResults(
						Integer.valueOf(pageNum));
			} else if (type.equals("2") || type.equals("3")) {
				String userId = json.getString("userId");
				hql = "select l,u from Life l ,User u, where l.userId = u.id and l.time < ? and( (l.userId in (select cu.userId from ClassUser cu where cu.classId in (select cu.classId from ClassUser cu where cu.userId = ?) ) )  or (l.userId in (select u.id from User u where u.type = 1) ) ) order by l.time desc";
				query = lifeDao
						.createQuery(hql, lastDate, Long.valueOf(userId))
						.setMaxResults(Integer.valueOf(pageNum));
			}
			if (query != null) {
				List list = query.list();
				if (list != null && list.size() > 0) {
					json1.put("lifeInfo", list);
				}
			}
		}
		return json1;
	}

	@Override
	public JSONObject saveCookbookInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		JSONArray jsons = json.getJSONArray("cookbook");
		if (jsons != null && jsons.size() > 0) {
			for (int i = 0; i < jsons.size(); i++) {
				Date date = new Date();
				JSONObject jsonObj = jsons.getJSONObject(i);
				String type = jsonObj.getString("type");
				String remark = jsonObj.getString("remark");
				String photo = jsonObj.getString("photo");
				String teacherId = jsonObj.getString("teacherId");
				List<Cookbook> lstCookbook = cookbookDao
						.queryEntitysByPropertys(
								new String[] { "date", "type" },
								DateUtils.formateDate(date,
										DateUtils.YYYY_MM_DD_WITN_HYPHEN),
								Integer.valueOf(type));
				if (lstCookbook != null && lstCookbook.size() > 0) {
					// update
					Cookbook cookbook = lstCookbook.get(0);
					cookbook.setPhoto(photo);
					cookbook.setRemark(remark);
					cookbook.setTeacherId(Long.valueOf(teacherId));
					cookbookDao.update(cookbook);
				} else {
					// insert
					Cookbook cookbook = new Cookbook();
					cookbook.setPhoto(photo);
					cookbook.setRemark(remark);
					cookbook.setTeacherId(Long.valueOf(teacherId));
					cookbook.setDate(DateUtils.formateDate(date,
							DateUtils.YYYY_MM_DD_WITN_HYPHEN));
					cookbook.setType(Short.valueOf(type));
					cookbookDao.save(cookbook);
				}
			}
		}
		return json1;
	}

	@Override
	public JSONObject queryCookbookInfo(JSONObject json) throws Exception {
		// TODO Auto-generated method stub
		JSONObject json1 = new JSONObject();
		json1.put("status", "1");
		String date = json.getString("date");
		List<Cookbook> lstCookbook = cookbookDao.findBy("date", DateUtils
				.parseStringToDate(date, DateUtils.YYYY_MM_DD_WITN_HYPHEN),"type",true);
		if(lstCookbook !=null && lstCookbook.size()>0){
			json1.put("cookbookInfo", lstCookbook);
		}
		return json1;
	}

	public IUserdao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserdao userDao) {
		this.userDao = userDao;
	}

	public ISignInDao getSignInDao() {
		return signInDao;
	}

	public void setSignInDao(ISignInDao signInDao) {
		this.signInDao = signInDao;
	}

	public ILifeDao getLifeDao() {
		return lifeDao;
	}

	public void setLifeDao(ILifeDao lifeDao) {
		this.lifeDao = lifeDao;
	}

	public ICookbookDao getCookbookDao() {
		return cookbookDao;
	}

	public void setCookbookDao(ICookbookDao cookbookDao) {
		this.cookbookDao = cookbookDao;
	}

}
