package action;

import model.answer_questionnaire;
import service.AppService;

public class GetAnsQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 5416716717340724806L;
	
	private int userId;
	private int questionnaireId;
	
	private answer_questionnaire quesContentFilled;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public answer_questionnaire getQuesContentFilled() {
		return quesContentFilled;
	}

	public void setQuesContentFilled(answer_questionnaire quesContentFilled) {
		this.quesContentFilled = quesContentFilled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	@Override
	public String execute() throws Exception{
		quesContentFilled = appService.getQuesContentFilled(userId, questionnaireId);
		request().setAttribute("quesContentFilled", quesContentFilled);
		return SUCCESS;
	}
	
}
