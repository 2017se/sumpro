package action;

import java.util.List;

import model.questionnaire;
import service.AppService;

public class GetQuesListCreatedAction extends BaseAction {

	private static final long serialVersionUID = -8566167707918511768L;
	
	private int userId;
	
	private List<questionnaire> quesListCreated;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public List<questionnaire> getQuesListCreated() {
		return quesListCreated;
	}

	public void setQuesListCreated(List<questionnaire> quesListCreated) {
		this.quesListCreated = quesListCreated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() throws Exception{
		
		quesListCreated = appService.getQuesListCreated(userId);
		request().setAttribute("quesListCreated", quesListCreated);
		return SUCCESS;
	}
	
}
