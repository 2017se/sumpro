package action;

import java.util.List;

import model.questionnaire;
import service.AppService;

public class DeleteQuesAction_n extends BaseAction{

	private static final long serialVersionUID = -961310091686170889L;
	
	private AppService appService;
	private int id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public String execute() throws Exception{
		questionnaire one_ques = appService.getQuesContent(id);
		appService.deleteQuesContent(one_ques);
		List<questionnaire> quesListPublished = appService.getAllQuesListPublished();
		request().setAttribute("quesListPublished", quesListPublished);
		return SUCCESS;
	}

}