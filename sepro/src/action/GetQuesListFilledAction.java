package action;

import java.util.List;

import model.answer_questionnaire;
import service.AppService;

public class GetQuesListFilledAction extends BaseAction {

	private static final long serialVersionUID = 9080023310728314652L;
	
	private int userId;
	
	private List<answer_questionnaire> quesListFilled;
	
	private AppService appService;
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public List<answer_questionnaire> getQuesListFilled() {
		return quesListFilled;
	}

	public void setQuesListFilled(List<answer_questionnaire> quesListFilled) {
		this.quesListFilled = quesListFilled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() throws Exception{
		quesListFilled = appService.getQuesListFilled(userId);
		request().setAttribute("quesListFilled", quesListFilled);
		return SUCCESS;
	}
	
}
