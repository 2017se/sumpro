package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.one_questiondao;

import model.one_question;

public class one_questiodaoimpl extends HibernateDaoSupport implements one_questiondao {
	
	@Override
	@SuppressWarnings("unchecked")
	public one_question geto_q(int q_id) {
		List<one_question> questions = (List<one_question>)getHibernateTemplate()
				.find("from ONE_QUESTION as question where question.id=?", q_id);
		return questions.get(0);
	}

	@Override
	public boolean delo_q(int q_id) {
		one_question question = geto_q(q_id);
		if(question != null){ //object exists
			getHibernateTemplate().delete(question);
			if(geto_q(q_id) == null)
				return true;
		}
		return false;
	}

	@Override
	public boolean updateo_q(one_question o_q) {
		// 没有检查update是否成功，直接返回true
		getHibernateTemplate().merge(o_q);
		return true;
	}

	@Override
	public boolean creo_q(one_question o_q) {
		return (boolean) getHibernateTemplate().save(o_q);
	}

}
