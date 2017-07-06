/********************************************************************************
 * 7.6 ����answer_questionnairedao
 ********************************************************************************/

package dao;

import java.util.List;

import model.answer_questionnaire;

public interface answer_questionnairedao {

	// �����ʾ�ش�
	public answer_questionnaire getAnswer_questionnaire(int userId, int questionnaireId);
	
	public List<answer_questionnaire> getAnswer_questionnaireByUser (int userId);
	
	public List<answer_questionnaire> getAnswer_questionnaireByQues(int questionnaireId);
	
	// ����ʾ�ش�
	public boolean saveAnswer_questionnaire(answer_questionnaire ans_ques);
	
	//���»ش�
	public boolean updateAnswer_questionnaire(answer_questionnaire ans_ques);
	
	//ɾ���ش�
	public boolean deleteAnswer_questionnaire(int UserId, int questionnaireId);
	
}
