package dao;

import model.one_question;
public interface one_questiondao {
		public one_question geto_q(int q_id);//����һ������
		public boolean delo_q(int q_id);//ɾ��һ������
		public boolean updateo_q(one_question o_q);//����һ������
		public boolean creo_q(one_question o_q);//����һ������
}
