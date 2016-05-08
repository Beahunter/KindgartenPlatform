package action.mobile;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import service.ISignInService;

import com.opensymphony.xwork2.ActionSupport;

public class SignInAction extends ActionSupport {

	private static final long serialVersionUID = -405957424206619635L;
	private ISignInService signInService;

	public String initClassStudentInfo() throws Exception {
		try {
			System.out.println("进入initClassStudentInfo");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String request1 = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(request1);
			if (json != null) {
				System.out.println(json.toString());
				String classid = (String) json.get("classId");
				JSONObject returnJson = null;
				if (classid != null && !classid.isEmpty()) {
					// 获取对应班级的学生信息
					returnJson = signInService.getStudentInfoByClassId(Long
							.valueOf(classid));
				}
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("initClassStudentInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("initClassStudentInfo response is null");
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

	public void signIn() {
		try {
			System.out.println("进入signIn ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				// 获取homework详情
				returnJson = signInService.signIn(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("signIn response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("signIn response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendLifeInfo() {
		try {
			System.out.println("进入sendLifeInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				returnJson = signInService.saveLifeInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("sendLifeInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("sendLifeInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void saveSignInPhoto() {
		try {
			System.out.println("进入saveSignInPhoto");
			MultiPartRequestWrapper request = (MultiPartRequestWrapper) ServletActionContext
					.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String[] s = request.getFileNames("inputName");
			File[] f = request.getFiles("inputName");
			String path = ServletActionContext.getServletContext().getRealPath(
					File.separator + "upload");
			File parentfile = new File(path);
			if (!parentfile.exists()) {
				parentfile.mkdir();
			}
			String newname = s[0];
			File newfile = new File(path + File.separator + newname);
			f[0].renameTo(newfile);
			System.out.println(newfile.getPath());
			// request.get
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getSignInfo() {
		try {
			System.out.println("进入getSignInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				// 获取homework详情
				returnJson = signInService.querySignInInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getSignInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getSignInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getLifeInfo() {
		try {
			System.out.println("进入getLifeInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				// 获取homework详情
				returnJson = signInService.queryLifeInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getSignInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getSignInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void saveCookbookInfo() {
		try {
			System.out.println("进入saveCookbookInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				returnJson = signInService.saveCookbookInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("saveCookbookInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("saveCookbookInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getCookbookInfo() {
		try {
			System.out.println("进入getCookbookInfo ");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String loginRequest = URLDecoder.decode(
					request.getParameter("orderJson"), "UTF-8");
			JSONObject json = JSONObject.fromObject(loginRequest);
			JSONObject returnJson = null;
			if (json != null) {
				System.out.println(json.toString());
				returnJson = signInService.queryCookbookInfo(json);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if (returnJson != null) {
					System.out.println("getCookbookInfo response :"
							+ returnJson.toString());
					out.println(returnJson.toString());
				} else {
					System.out.println("getCookbookInfo response is null");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ISignInService getSignInService() {
		return signInService;
	}

	public void setSignInService(ISignInService signInService) {
		this.signInService = signInService;
	}

}
