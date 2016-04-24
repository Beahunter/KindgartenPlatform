package action.mobile;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.IBasicService;
import bean.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = -7808734614538696482L;
	private IBasicService basicService;
//    protected Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	public String login() throws Exception{
		 System.out.println("进入login ");
		 HttpServletRequest request=ServletActionContext.getRequest();  
		 HttpServletResponse response=ServletActionContext.getResponse();  
		String loginRequest = URLDecoder.decode(request.getParameter("orderJson"),"UTF-8");
		JSONObject json = JSONObject.fromObject(loginRequest);
		User user = new User();
		if(json !=null){
			System.out.println(json.toString());
			String  phoneNumber= (String)json.get("phoneNumber");
			String  password= (String)json.get("password");
			String  type = (String)json.get("type");
			if(phoneNumber !=null && !phoneNumber.isEmpty()){
			 user.setPhoneNumber(Long.valueOf(phoneNumber));
			}
			user.setPassword(password);
			if(type !=null && !type.isEmpty()){
			 user.setType(Short.valueOf(type));
			}
			JSONObject jsonobj = basicService.login(user);

			response.setContentType("text/html;charset=utf-8");  
		    PrintWriter out = response.getWriter();  
		    if(jsonobj !=null){
		     System.out.println("login response :" +jsonobj.toString());
			 out.println(jsonobj.toString());  
		    }else{
		    	System.out.println("logign response is null");	
		    }
		    out.flush();  
		    out.close(); 
		}
        return null;
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
