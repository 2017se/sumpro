package action;

import java.util.List;

import model.answer_questionnaire;
import model.questionnaire;
import model.user;
import service.AppService;

/**
 * �����û���ת�����������ġ�ҳ������󣬲���Ҫ�������������user�����������ʾ�
 * �б�List<questionnarie>����д�����ʾ��б�List<answer_questionnaire>
 * */

public class PersonalCenterAction extends BaseAction{

	private static final long serialVersionUID = 6616192234514639348L;

	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	@Override
	public String execute() throws Exception{
		
		user user = (user) session().getAttribute("user");
		
		List<questionnaire> quesListCreated = appService.getQuesListCreated(user.getId());
		request().setAttribute("quesListCreated",quesListCreated);
		
		List<answer_questionnaire> quesListFilled = appService.getQuesListFilled(user.getId());
		request().setAttribute("quesListFilled", quesListFilled);
		
		return SUCCESS;
	}
}
