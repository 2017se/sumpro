package dao;

import model.questionnaire;

public interface questionnairedao {
		//�ʾ�ɾ��
		public questionnaire getq(int id);
		//�½��ʾ�
		public boolean setq(questionnaire q);
		//�ʾ��޸�
		public boolean updateq(questionnaire q);
		//�ʾ�ɾ��
		public boolean deleteq(int id);
}
