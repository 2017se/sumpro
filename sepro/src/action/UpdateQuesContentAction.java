package action;

import model.questionnaire;
import service.AppService;

public class UpdateQuesContentAction extends BaseAction{

	private static final long serialVersionUID = 7856877169681196218L;
	
	private questionnaire quesContent;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public questionnaire getQuesContent() {
		return quesContent;
	}

	public void setQuesContent(questionnaire quesContent) {
		this.quesContent = quesContent;
	}


	@Override
	public String execute() throws Exception{
		appService.updateQuesContent(quesContent);
		return SUCCESS;
	}
	
}
