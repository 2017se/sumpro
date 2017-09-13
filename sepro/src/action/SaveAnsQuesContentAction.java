package action;

import java.io.PrintWriter;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

import model.answers;
import model.answer_questionnaire;
import service.AppService;

public class SaveAnsQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 944447331578943077L;
	
	private int u_id;
	private int q_id;
	private Date submit_time;
	private int if_complete;
	private String answers;

	private AppService appService;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public Date getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}

	public int getIf_complete() {
		return if_complete;
	}

	public void setIf_complete(int if_complete) {
		this.if_complete = if_complete;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public void save() throws Exception{
		//get user
		if(u_id == 0){
			//get ip
			String ip;
			if(request().getHeader("x-forwarded-for")==null){
				ip = request().getRemoteAddr();
			} else {
				ip = request().getHeader("x-forwarded-for");
			}
			//check ip
			if(appService.existIp(ip)){
				response().setContentType("text/plain,charset=utf-8");
				PrintWriter out = response().getWriter();
				out.println("error");
				out.flush();
				out.close();
				return;
			}
			u_id = appService.getUserTemp(ip).getId();
		}
		
		answer_questionnaire ansQuesContent = new answer_questionnaire();
		ansQuesContent.setQ_id(q_id);
		ansQuesContent.setU_id(u_id);
		ansQuesContent.setSubmit_time(submit_time);
		ansQuesContent.setIf_complete(if_complete);
		
		JSONArray jsonAnsArray = new JSONArray(answers);
		JSONObject jsonAnsObject = null;
		answers javaAnsObject = null;
		for(int i = 0; i < jsonAnsArray.length(); i++){
			jsonAnsObject = jsonAnsArray.optJSONObject(i);
			javaAnsObject = new answers();
			javaAnsObject.setO_id(jsonAnsObject.optInt("o_id"));
			//javaAnsObject.setU_id(jsonAnsObject.optInt("u_id"));
			javaAnsObject.setU_id(u_id);
			javaAnsObject.setAnswer(jsonAnsObject.optString("answer"));
			ansQuesContent.getAnsList().add(javaAnsObject);
		}
		
		appService.saveAnsQuesContent(ansQuesContent);
		
		//response to ajax
		response().setContentType("text/plain,charset=utf-8");
		PrintWriter out = response().getWriter();
		out.println("success");
		out.flush();
		out.close();
	}
	
}
