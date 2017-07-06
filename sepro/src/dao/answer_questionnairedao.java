/********************************************************************************
 * 7.6 创建answer_questionnairedao
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
	
}
