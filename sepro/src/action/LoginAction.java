/*****************************************************************************
 * 7.11 getParameter()->struts注入
 *      实现“用户登录”到“发布问卷”页面的跳转，request.setAttribute(quesListCreated)
 *****************************************************************************/

package action;

import java.util.List;

import model.questionnaire;
import model.user;

import service.AppService;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String identity;
	
	private String password;

	
	private AppService appService;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
		
	
	@Override
	public String execute() throws Exception {
		user user = appService.login(identity, password);
		if((user) != null) {
			session().setAttribute("user", user);
			List<questionnaire> quesListCreated = appService.getQuesListCreated(user.getId());
			request().setAttribute("quesListCreated", quesListCreated);
			return SUCCESS;
		}
		return NONE;
	}

}
