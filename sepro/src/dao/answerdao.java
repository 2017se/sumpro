/********************************************************************
 * 9.12 ���getAnsListByQuesId�����ڵ���������������д�
 ********************************************************************/
package dao;
import java.util.List;

import model.answers;

public interface answerdao {
	
		//���answer
		public answers getan(int o_id,int u_id);
		
		//�ش�һ������
		public boolean setan(answers an);
		
		//ɾ��һ����
		public boolean deletean(int o_id,int u_id);
		
		//����һ����
		public boolean updatean(answers an);
		
		//�õ�������������лش�
		public List<answers> getAnsListByQuesId(int questionId);
		
}
