package action;

import java.util.List;

import model.user;
import service.AppService;

public class AllowUserAction_n extends BaseAction{

	private static final long serialVersionUID = -961310091686170889L;
	
	private AppService appService;
	private int id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws Exception{
		appService.allowUser(id);
		List<user> users = appService.getAllUsers();
		request().setAttribute("Users", users);
		return SUCCESS;
	}

}