/*****************************************************************************
 * 7.11 getParameter()->strutsע��
 *      ʵ�֡��û���¼�����������ʾ�ҳ�����ת��request.setAttribute(quesListCreated)
 *****************************************************************************/

package action;

import java.util.List;

import model.questionnaire;
import model.user;

import service.AppService;

public class AdminLoginAction_n extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String identity;
	
	private String password;
	
	private List<questionnaire> quesListCreated;

	
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
	
	public List<questionnaire> getQuesListCreated() {
		return quesListCreated;
	}

	public void setQuesListCreated(List<questionnaire> quesListCreated) {
		this.quesListCreated = quesListCreated;
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
		if((user) != null && user.getRole()==1) {
			session().setAttribute("user", user);
			List<user> users=appService.getAllUsers();
			request().setAttribute("Users", users);
			return SUCCESS;
		}
		request().setAttribute("action", "login");
		request().setAttribute("message", "�û��������벻��ȷ");
		return NONE;
	}

}
