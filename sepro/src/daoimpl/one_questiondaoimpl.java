/********************************************************************************* 
 * 6.30 修改拼写：one_questioimpl.java->one_questionimpl.java
 *      修改hql语句中ONE_QUESTION->one_question[hql语法里面是POJO对象而不是table]
 * 7.5   fix：使用List.get(0)前先检验是否为empty
 *********************************************************************************/

package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.one_questiondao;

import model.one_question;

public class one_questiondaoimpl extends HibernateDaoSupport implements one_questiondao {
	
	@Override
	@SuppressWarnings("unchecked")
	public one_question geto_q(int q_id) {
		List<one_question> questions = (List<one_question>)getHibernateTemplate()
				.find("from one_question as question where question.id=?", q_id);
		if(questions.isEmpty()){
			return null;
		}
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
	public int creo_q(one_question o_q) {
		getHibernateTemplate().save(o_q);
		getHibernateTemplate().flush();
		return o_q.getId();
	}

}
