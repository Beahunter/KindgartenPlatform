package action.web;

import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.IBasicService;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction extends ActionSupport {

	private static final long serialVersionUID = -7511982957888973602L;
    private IBasicService basicService;
	public String login(){
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
				String name = (String) json.get("name");
				String password = (String) json.get("password");
				String type = (String) json.get("type");
                user.setName(name);
				user.setPassword(password);
				if (type != null && !type.isEmpty()) {
					user.setType(Short.valueOf(type));
				}
				JSONObject jsonobj = basicService.webLogin(user);
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
	
	public void getAllClassesInfo(){
		try {
		System.out.println("进入getAllClassesInfo ");
		HttpServletResponse response = ServletActionContext.getResponse();
	   // 查询classes
	   JSONObject jsonobj = basicService.queryClassesInfo();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (jsonobj != null) {
			System.out.println("getAllClassesInfo response :" + jsonobj.toString());
			out.println(jsonobj.toString());
		} else {
			System.out.println("getAllClassesInfo response is null");
		}
		out.flush();
		out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAllUserInfo(){
		try {
			System.out.println("进入getAllUserInfo ");
			HttpServletResponse response = ServletActionContext.getResponse();
		   // 查询users
		   JSONObject jsonobj = basicService.queryAllUsersInfo();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (jsonobj != null) {
				System.out.println("getAllUserInfo response :" + jsonobj.toString());
				out.println(jsonobj.toString());
			} else {
				System.out.println("getAllUserInfo response is null");
			}
			out.flush();
			out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void getAllSubjectInfo(){
		try {
			System.out.println("进入getAllSubjectInfo ");
			HttpServletResponse response = ServletActionContext.getResponse();
		   // 查询subjects
		   JSONObject jsonobj = basicService.queryAllSubjectInfo();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (jsonobj != null) {
				System.out.println("getAllSubjectInfo response :" + jsonobj.toString());
				out.println(jsonobj.toString());
			} else {
				System.out.println("getAllSubjectInfo response is null");
			}
			out.flush();
			out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public IBasicService getBasicService() {
		return basicService;
	}
	public void setBasicService(IBasicService basicService) {
		this.basicService = basicService;
	}
	
	
}
