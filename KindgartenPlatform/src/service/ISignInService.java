package service;

import net.sf.json.JSONObject;

public interface ISignInService {

	 public JSONObject getStudentInfoByClassId(Long classId);
	 
	 public JSONObject signIn(JSONObject json) throws Exception;
	 
	 public JSONObject saveLifeInfo(JSONObject json) throws Exception;
	 
	 public JSONObject saveCookbookInfo(JSONObject json) throws Exception;
	 
	 public JSONObject querySignInInfo(JSONObject json) throws Exception;
   
	 public JSONObject queryLifeInfo(JSONObject json) throws Exception;
	 
	 public JSONObject queryCookbookInfo(JSONObject json) throws Exception;
}
