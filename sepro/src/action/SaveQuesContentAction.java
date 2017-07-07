package action;

import model.questionnaire;
import service.AppService;

public class SaveQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 5245101723418485614L;
	
	private questionnaire quesContent;
	
	private int questionnaireId;

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

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	@Override
	public String execute() throws Exception{
		questionnaireId = appService.saveQuesContent(quesContent);
		request().setAttribute("questionnaireid", questionnaireId);
		return SUCCESS;
	}
	
}
