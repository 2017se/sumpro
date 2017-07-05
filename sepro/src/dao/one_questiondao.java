package dao;

import model.one_question;
public interface one_questiondao {
		public one_question geto_q(int q_id);//返回一个问题
		public boolean delo_q(int q_id);//删除一个问题
		public boolean updateo_q(one_question o_q);//更新一个问题
		public boolean creo_q(one_question o_q);//创建一个问题
}
