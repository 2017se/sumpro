package action;

import model.user;

import service.AppService;

public class UpdateUserInfoAction extends BaseAction {

	private static final long serialVersionUID = 2694178423080407363L;
	
	private String username;
	
	private String name;
	
	private String mail;
	
	private String qq;
	
	private String phone;

	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String execute() throws Exception{
		user user = (user)session().getAttribute("user");
		user.setUsername(username);
		user.setMail(mail);
		user.setName(name);
		user.setPhone(phone);
		user.setQq(qq);
		appService.updateUserInfo(user);
		return SUCCESS;
	}
}
