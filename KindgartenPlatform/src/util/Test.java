package util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import bean.Class;
import bean.User;

public class Test {
	public final static Map map = new HashMap();  

	static {  

	    map.put("key1", "value1");  

	    map.put("key2", "value2");  

	}  
	
	public static void  a() {
		
		String v = (String) map.get("key1");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a();
//       User user = new User();
//       user.setId(1L);
//       user.setName("123");
//       Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//       String json = gson.toJson(user);
//      JSONObject js = JSONObject.fromObject(user);
//      User user1 = (User) js.toBean(js, User.class);
//       
//       System.out.println(user1.getName());
//       String a  = "";
////       System.out.println(Long.valueOf(a));
//       JSONObject js = new JSONObject();
//       Class c = new Class();
//       Class c1 = new Class();
//       c.setId(1L);
//       c.setName("zz");
//       c1.setId(1L);
//       c1.setName("zz");
//       List<User> ll = new ArrayList<User>();
//       ll.add(user);
//       ll.add(user);
////       List<bean.Class> list = new ArrayList<bean.Class>();
////       list.set(0, c);
////       list.set(1, c1);
//       js.put("class", ll);
//       System.out.println(js.toString());
       System.out.println(System.currentTimeMillis());
	}

}
