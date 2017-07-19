package action;

import java.util.List;

import model.questionnaire;
import service.AppService;

public class GetQuesListPublishedAction extends BaseAction{

	private static final long serialVersionUID = -961310091686170889L;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws Exception{
		List<questionnaire> quesListPublished = appService.getAllQuesListPublished();
		request().setAttribute("quesListPublished", quesListPublished);
		return SUCCESS;
	}

}
