package util;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import bean.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       User user = new User();
       user.setId(1L);
       user.setName("123");
       Gson gson = new GsonBuilder().disableHtmlEscaping().create();
       String json = gson.toJson(user);
      JSONObject js = JSONObject.fromObject(json);
      
       
       System.out.println(js.get("id"));
	}

}
