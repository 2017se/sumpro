/*****************************************************************************
 * 7.19 ´´½¨
 ****************************************************************************/
package action;

import java.io.PrintWriter;
import java.util.Date;

import service.AppService;

public class PublishQuestionnaireAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private int questionnaireId;
	private Date set_date;
	private Date end_date;
	
	private AppService appService;

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Date getSet_date() {
		return set_date;
	}

	public void setSet_date(Date set_date) {
		this.set_date = set_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public void publish() throws Exception{
		
		response().setContentType("text/html,charset=utf-8");
		PrintWriter out = response().getWriter();
		
		if(appService.publishQuestionnaire(questionnaireId, set_date, end_date)){
			out.println("success");
		}
		else{
			out.println("fail");
		}
		out.flush();
		out.close();
	}
	
}
