package action;

import model.questionnaire;
import service.AppService;

public class GetQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 4351870503044426944L;
	
	private int questionnaireId;
	private questionnaire quesContent;
	
	private AppService appService;
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	public questionnaire getQuesContent() {
		return quesContent;
	}

	public void setQuesContent(questionnaire quesContent) {
		this.quesContent = quesContent;
	}

	@Override
	public String execute() throws Exception{
		quesContent = appService.getQuesContent(questionnaireId);
		request().setAttribute("quesContent",quesContent);
		return SUCCESS;
	}

}
