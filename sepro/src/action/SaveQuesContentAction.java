package action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import model.one_question;
import model.q_options;
import model.questionnaire;
import service.AppService;

public class SaveQuesContentAction extends BaseAction {

	private static final long serialVersionUID = 5245101723418485614L;
	
	private int u_id;
	private String title;
	private String instruction;
	private Date set_date;
	private Date end_date;
	private String questions;

	private AppService appService;
	
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
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

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public void save() throws Exception{
		
		JSONArray jsonQuesArray = new JSONArray(questions);
		Set<one_question> javaQuesSet = new HashSet<one_question>();
		
		JSONObject jsonQuesObject = null;
		one_question javaQuesObject = null;

		JSONObject jsonOptionObject = null;
		q_options javaOptionObject = null;
		
		for(int i = 0; i < jsonQuesArray.length(); i++){
			jsonQuesObject = jsonQuesArray.optJSONObject(i);
			
			javaQuesObject = new one_question();
			javaQuesObject.setTitle_num(jsonQuesObject.optInt("title_num"));
			javaQuesObject.setStem(jsonQuesObject.optString("stem"));
			javaQuesObject.setType(jsonQuesObject.optInt("type"));
			javaQuesObject.setNessecity(jsonQuesObject.optInt("nessecity"));
			
			JSONArray jsonOptionArray = jsonQuesObject.optJSONArray("options");
			for(int j = 0; j < jsonOptionArray.length(); j++){
				jsonOptionObject = jsonOptionArray.optJSONObject(j);
				
				javaOptionObject = new q_options();
				javaOptionObject.setTitle(jsonOptionObject.optString("title"));
				javaOptionObject.setProperty(jsonOptionObject.optString("property"));
				javaQuesObject.getOptions().add(javaOptionObject);
			}
			javaQuesSet.add(javaQuesObject);
		}
		
		questionnaire questionnaire = new questionnaire();
		questionnaire.setU_id(u_id);
		questionnaire.setTitle(title);
		questionnaire.setInstruction(instruction);
		questionnaire.setSet_date(set_date);
		questionnaire.setEnd_date(end_date);
		for(one_question ques : javaQuesSet){
			questionnaire.getQuestions().add(ques);
		}
		
		int quesId = appService.saveQuesContent(questionnaire);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("quesId", String.valueOf(quesId));
		response().setContentType("text/html,charset=utf-8");
		PrintWriter out = response().getWriter();
		out.println(jsonObj.toString());
		out.flush();
		out.close();
	}

}
