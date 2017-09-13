/********************************************************************************
 * 7.6 创建answer_questionnairedao
 * 9.12添加getAnsQuesListByQuesId
 ********************************************************************************/

package dao;

import java.util.List;

import model.answer_questionnaire;

public interface answer_questionnairedao {

	// 查找问卷回答
	public answer_questionnaire getAnswer_questionnaire(int userId, int questionnaireId);
	
	public List<answer_questionnaire> getAnswer_questionnaireByUser (int userId);
	
	public List<answer_questionnaire> getAnswer_questionnaireByQues(int questionnaireId);
	
	// 添加问卷回答
	public boolean saveAnswer_questionnaire(answer_questionnaire ans_ques);
	
	//更新回答
	public boolean updateAnswer_questionnaire(answer_questionnaire ans_ques);
	
	//删除回答
	public boolean deleteAnswer_questionnaire(int UserId, int questionnaireId);
	
	/**
	 * 得到某一问卷的回答记录的列表，其中ansList空，questionnaire为空
	 * **/
	List<answer_questionnaire> getAnsQuesListByQuesId(int questionnaireId);
}
