package service;

import java.util.Date;

import net.sf.json.JSONObject;
import bean.Homework;
import bean.Study;
import bean.Temperature;
import bean.User;

/**
 * 系统基础操作处理（登录、注册等）
 * @author Administrator
 *
 */
public interface IBasicService {
	/**
	 * 登录判断
	 * @param user
	 * @return true：登录成功 false:用户不存在
	 */
	public JSONObject login(User user) throws Exception;
	/**
	 * 注册判断
	 * @param user
	 * @return true :注册成功 false：用户已存在
	 */
	public boolean register(User user);
	
	public JSONObject webLogin(User user) throws Exception;
	
	public JSONObject saveTemperature(Temperature temp) throws Exception;
	
	public JSONObject saveHomework(Homework homework) throws Exception;
	
	public JSONObject saveStudy(Study study) throws Exception;
	
	public JSONObject queryStudyInfo(Long classId,Date date) throws Exception;
	
	public JSONObject queryHomeworkInfo(JSONObject json) throws Exception;
	
	public JSONObject queryTemperatureInfo(JSONObject json) throws Exception;
	
	public JSONObject updateUserPassword(JSONObject json) throws Exception;
	
	public JSONObject saveOrUpdateUser(JSONObject json) throws Exception;
	
	public JSONObject updateUserHeaderImage(Long userId,String photo) throws Exception;
    
	public JSONObject queryClassesInfo() throws Exception;
	public JSONObject queryAllUsersInfo() throws Exception;
	public JSONObject queryAllSubjectInfo() throws Exception;
	
}
