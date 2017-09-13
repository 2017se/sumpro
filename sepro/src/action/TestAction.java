package action;

import model.user;

import java.util.List;

import model.answer_questionnaire;
import model.answers;
import model.questionnaire;
import model.one_question;
import model.q_options;

import service.AppService;

public class TestAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private AppService appService;
	
	private q_options opt = new q_options();
	private one_question ques = new one_question();
	private questionnaire paper = new questionnaire();
	private user user = new user();
	private answer_questionnaire ans = new answer_questionnaire();

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public q_options getOpt() {
		return opt;
	}

	public void setOpt(q_options opt) {
		this.opt = opt;
	}

	public one_question getQues() {
		return ques;
	}

	public void setQues(one_question ques) {
		this.ques = ques;
	}

	public questionnaire getPaper() {
		return paper;
	}

	public void setPaper(questionnaire paper) {
		this.paper = paper;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public answer_questionnaire getAns() {
		return ans;
	}

	public void setAns(answer_questionnaire ans) {
		this.ans = ans;
	}
	
	
	@Override
	public String execute() throws Exception{
		
		paper.setU_id(1);
		paper.setInstruction("test");
		paper.setTitle("test");
		
		ques.setTitle_num(1);
		ques.setStem("test");
		
		opt.setTitle("A");
		
		ques.getOptions().add(opt);
		paper.getQuestions().add(ques);
		
		// saveQuesContent()≤‚ ‘
		/*****************************************************************
		appService.saveQuesContent(paper);
		*****************************************************************/
		
		// getQuesContent()≤‚ ‘
		/*****************************************************************
		questionnaire newQues = appService.getQuesContent(11);
		System.out.println("id:\t" + newQues.getId());
		System.out.println("title:\t" + newQues.getTitle());
		System.out.println("user:\t" + newQues.getU_id());
		for(one_question o_q : newQues.getQuestions()){
			System.out.println("--Question id:\t" + o_q.getId());
			System.out.println("----title num:\t" + o_q.getTitle_num());
			System.out.println("----statement:\t" + o_q.getStem());
			for(q_options op : o_q.getOptions()){
				System.out.println("------Question id:\t" + op.getQ_id());
				System.out.println("------Option title:\t" + op.getTitle());
			}
		}
		******************************************************************/

		// getQuesListCreated()≤‚ ‘
		/******************************************************************
		List<questionnaire>quesList = appService.getQuesListCreated(1);
		System.out.println("user ID:\t" + 1 );
		for(questionnaire ques : quesList){
			System.out.println("-ID:\t" +ques.getId());
			System.out.println("---title:\t" + ques.getTitle());
			System.out.println("---instruction:\t" + ques.getInstruction());
			System.out.println("---question num:\t" + ques.getQuestions().size());
		}
		*******************************************************************/

		// updateQuesContent()≤‚ ‘
		/*******************************************************************
		questionnaire paper1 = appService.getQuesContent(11);
		
		one_question ques1 = new one_question();
		ques1.setStem(null);
		ques1.setTitle_num(3);
		
		q_options opt1 = new q_options();
		opt1.setTitle("P");
		opt1.setProperty(null);
		
		ques1.getOptions().add(opt1);
		paper1.getQuestions().add(ques1);
		
		appService.updateQuesContent(paper1);
		***********************************************************************/
		
		// deleteQuesContent()≤‚ ‘
		/***********************************************************************
		questionnaire paper1 = appService.getQuesContent(11);
		appService.deleteQuesContent(paper1);
		***********************************************************************/
		
		int questionId = 87;
		String path = appService.getDataDiagram(questionId);
		System.out.println(path);
		return SUCCESS;

	}
}
