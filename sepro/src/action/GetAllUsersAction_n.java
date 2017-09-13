package action;

import java.util.List;

import model.user;
import service.AppService;

public class GetAllUsersAction_n extends BaseAction{

	private static final long serialVersionUID = -961310091686170889L;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws Exception{
		List<user> users = appService.getAllUsers();
		request().setAttribute("Users", users);
		return SUCCESS;
	}

}