package action.mobile;

import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

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
			String request1 = URLDecoder.decode(request.getParameter("orderJson"),
					"UTF-8");
			JSONObject json = JSONObject.fromObject(request1);
			if(json !=null){
			String  classid = (String)json.get("classId");
			JSONObject returnJson =null;
			if(classid !=null && !classid.isEmpty()){
					returnJson = signInService.getStudentInfoByClassId(Long.valueOf(classid));
			}
			// 获取对应班级的学生信息
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
	public ISignInService getSignInService() {
		return signInService;
	}
	public void setSignInService(ISignInService signInService) {
		this.signInService = signInService;
	}

}
