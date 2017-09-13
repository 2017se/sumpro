package action;

import java.util.List;

import model.answer_questionnaire;
import model.questionnaire;
import service.AppService;

public class DataAnalysisAction extends BaseAction{

	private static final long serialVersionUID = 3274371050158560684L;
	
	private int questionnaireId;
	
	private AppService appService;

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	@Override
	public String execute() throws Exception{
		
		List<answer_questionnaire> ansQuesList = appService.getAnsQuesListByQuestionnaire(questionnaireId);
		questionnaire questionnaire = appService.getQuesContent(questionnaireId);
		
		request().setAttribute("ansQuesList",ansQuesList);
		request().setAttribute("questionnaire",questionnaire);
		
		return SUCCESS;
	}
	
}
