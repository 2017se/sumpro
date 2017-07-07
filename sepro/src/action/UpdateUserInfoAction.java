package action;

import model.user;

import service.AppService;

public class UpdateUserInfoAction extends BaseAction {

	private static final long serialVersionUID = 2694178423080407363L;
	
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
	
	@Override
	public String execute() throws Exception{
		appService.updateUserInfo(user);
		return SUCCESS;
	}
	
}
