package action.mobile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = -7808734614538696482L;
    protected Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	public void login(){
		
    }
}
