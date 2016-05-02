package action.mobile;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.IBasicService;
import util.DateUtils;
import bean.Homework;
import bean.Study;
import bean.Temperature;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = -7808734614538696482L;
	private IBasicService basicService;

	// protected Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	public String login() throws Exception {
		try {

			System.out.println("进入login ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			User user = new User();
			if (json != null) {
				System.out.println(json.toString());
				String phoneNumber = (String) json.get("phoneNumber");
				String password = (String) json.get("password");
				String type = (String) json.get("type");
				if (phoneNumber != null && !phoneNumber.isEmpty()) {
					user.setPhoneNumber(Long.valueOf(phoneNumber));
				}
				user.setPassword(password);
				if (type != null && !type.isEmpty()) {
					user.setType(Short.valueOf(type));
				}
				JSONObject jsonobj = basicService.login(user);

				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (jsonobj != null) {
					System.out.println("login response :" + jsonobj.toString());
					out.println(jsonobj.toString());
				} else {
					System.out.println("logign response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void sendTemperatureInfo() {
		try {
			System.out.println("进入sendTemperatureInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			Temperature temp = new Temperature();
			if (json != null) {
				System.out.println(json.toString());
				// 保存温度详情
				String teacherId = json.getString("teacherId");
				String temperature = json.getString("temperature");
				String remark = json.getString("remark");
				String childId = json.getString("childId");
				if (teacherId != null && !teacherId.isEmpty()) {
					temp.setTeacherId(Long.valueOf(teacherId));
				}
				if (temperature != null && !temperature.isEmpty()) {
					temp.setTemperature(Float.valueOf(temperature));
				}
				if (childId != null && !childId.isEmpty()) {
					temp.setChildId(Long.valueOf(childId));
				}
				temp.setRemark(remark);
				temp.setDate(DateUtils.formateDate(new Date(),
						DateUtils.YYYY_MM_DD_WITN_HYPHEN));
				JSONObject returnJson = null;
				returnJson = basicService.saveTemperature(temp);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("sendTemperatureInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("sendTemperatureInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendHomeworkInfo() {
		try {
			System.out.println("进入sendHomeworkInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			Homework homework = new Homework();
			if (json != null) {
				System.out.println(json.toString());
				// 保存作业详情
				String teacherId = json.getString("teacherId");
				String content = json.getString("content");
				String classId = json.getString("classId");
				if (teacherId != null && !teacherId.isEmpty()) {
					homework.setTeacherId(Long.valueOf(teacherId));
				}
				if (classId != null && !classId.isEmpty()) {
					homework.setClassId(Long.valueOf(classId));
				}
				homework.setContent(content);
				homework.setDate(DateUtils.formateDate(new Date(),
						DateUtils.YYYY_MM_DD_WITN_HYPHEN));
				JSONObject returnJson = null;
				returnJson = basicService.saveHomework(homework);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("sendTemperatureInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("sendTemperatureInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendStudyInfo() {
		try {
			System.out.println("进入sendStudyInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			Study study = new Study();
			if (json != null) {
				System.out.println(json.toString());
				// 保存作业详情
				String teacherId = json.getString("teacherId");
				String content = json.getString("content");
				String classId = json.getString("classId");
				String subjectId = json.getString("subjectId");
				if (teacherId != null && !teacherId.isEmpty()) {
					study.setTeacherId(Long.valueOf(teacherId));
				}
				if (classId != null && !classId.isEmpty()) {
					study.setClassId(Integer.valueOf(classId));
				}
				if (subjectId != null && !subjectId.isEmpty()) {
					study.setSubjectId(Integer.valueOf(subjectId));
				}
				study.setContent(content);
				study.setDate(DateUtils.formateDate(new Date(),
						DateUtils.YYYY_MM_DD_WITN_HYPHEN));
				JSONObject returnJson = null;
				returnJson = basicService.saveStudy(study);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("sendTemperatureInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("sendTemperatureInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getStudyInfo() {
		try {
			System.out.println("进入getStudyInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			if (json != null) {
				String classId = json.getString("classId");
				String date = json.getString("date");
				JSONObject returnJson = null;
				if (classId != null && !classId.isEmpty() && date != null
						&& !date.isEmpty()) {
					// 获取学习内容详情
					returnJson = basicService.queryStudyInfo(Long
							.valueOf(classId), DateUtils.parseStringToDate(
							date, DateUtils.YYYY_MM_DD_WITN_HYPHEN));
				}
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getStudyInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getStudyInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getHomeworkInfo() {
		try {
			System.out.println("进入getHomeworkInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				// 获取homework详情
				returnJson = basicService.queryHomeworkInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getHomeworkInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getHomeworkInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getTempInfo() {
		try {
			System.out.println("进入getTempInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				// 获取温度详情
				returnJson = basicService.queryTemperatureInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getTempInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getTempInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("jijiji");
		return super.execute();
	}

	public IBasicService getBasicService() {
		return basicService;
	}

	public void setBasicService(IBasicService basicService) {
		this.basicService = basicService;
	}

}
