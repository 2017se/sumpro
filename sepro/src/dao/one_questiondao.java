package dao;

import model.one_question;

public interface one_questiondao {
	
	//返回一个问题
	public one_question geto_q(int q_id);
	
	//删除一个问题
	public boolean delo_q(int q_id);
	
	//更新一个问题
	public boolean updateo_q(one_question o_q);
	
	//创建一个问题
	public int creo_q(one_question o_q);
	
	//根据问卷id（
}
