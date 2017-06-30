package action;

import javax.servlet.http.Cookie;

import model.user;
import service.AppService;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String identity;
	private String password;
	
	private void getIdentify(){
		this.identity = request().getParameter("identity");
	}
	
	private void getPassword(){
		this.password = request().getParameter("password");
	}
	
	private AppService appService;
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
		
	@Override
	//@SuppressWarnings("null")
	public String execute() throws Exception {
		this.getIdentify();
		this.getPassword();
		user user = appService.login(identity, password);
		System.out.println(user.getName());
		if((user ) != null){
			return SUCCESS;
		}
		return NONE;
		
	}


}
