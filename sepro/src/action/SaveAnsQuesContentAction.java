package action;

import model.answer_questionnaire;

import service.AppService;

public class SaveAnsQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 944447331578943077L;
	
	private answer_questionnaire ansQuesContent;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public answer_questionnaire getAnsQuesContent() {
		return ansQuesContent;
	}

	public void setAnsQuesContent(answer_questionnaire ansQuesContent) {
		this.ansQuesContent = ansQuesContent;
	}
	
	@Override
	public String execute() throws Exception{
		appService.saveAnsQuesContent(ansQuesContent);
		return SUCCESS;
	}
	
}
