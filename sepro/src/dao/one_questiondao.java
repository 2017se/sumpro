package dao;

import model.one_question;

public interface one_questiondao {
	
	//����һ������
	public one_question geto_q(int q_id);
	
	//ɾ��һ������
	public boolean delo_q(int q_id);
	
	//����һ������
	public boolean updateo_q(one_question o_q);
	
	//����һ������
	public int creo_q(one_question o_q);
	
	//�����ʾ�id��
}
