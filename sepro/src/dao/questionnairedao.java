/******************************************************************
 * 7.4 ��ӷ���getQuesListByUser������userID�����ʾ�
 * 7.18��ӷ���getAllQuesList���õ������ѷ����ʾ�
 ******************************************************************/
package dao;

import java.util.List;

import model.questionnaire;

public interface questionnairedao {
	
		//�����ʾ�
		public questionnaire getq(int id);
		
		//�½��ʾ�
		public int setq(questionnaire q);
		
		//�ʾ��޸�
		public boolean updateq(questionnaire q);
		
		//�ʾ�ɾ��
		public boolean deleteq(int id);
		
		//����userId�����ʾ�
		public List<questionnaire> getQuesListByUser(int userId);
		
		//�õ������ѷ����ʾ�
		public List<questionnaire> getAllQuesList();
}
