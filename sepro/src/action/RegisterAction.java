package action;

import model.user;
import service.AppService;

public class RegisterAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String mail;
	private String qq;
	private String phone;
	private int role;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	
	@Override
	public String execute() throws Exception{
		
		this.username = request().getParameter("username");
		this.password = request().getParameter("password");
		this.name = request().getParameter("name");
		this.mail = request().getParameter("mail");
		this.phone = request().getParameter("phone");
		this.qq = request().getParameter("qq");
		this.role = 0; //default
		
		user userTemp = new user();
		userTemp.setName(name);
		userTemp.setUsername(username);
		userTemp.setPassword(password);
		userTemp.setPhone(phone);
		userTemp.setQq(qq);
		userTemp.setRole(role);
		
		if(appService.register(userTemp) == 1){
			return SUCCESS;
		}
		else{
			return NONE;
		}
		
	}


}
