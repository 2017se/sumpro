package action;

import model.user;

import service.AppService;

public class GetUserInfoAction extends BaseAction{

	private static final long serialVersionUID = 6704267269735367640L;
	
	private int userId;
	
	private user user;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	@Override
	public String execute() throws Exception{
		user = appService.getUserInfo(userId);
		request().setAttribute("user", user);
		return SUCCESS;
	}
	
}
