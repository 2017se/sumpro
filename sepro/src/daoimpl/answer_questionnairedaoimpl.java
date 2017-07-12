/********************************************************************************
 * 7.6 ´´½¨answer_questionnairedaoimpl
 ********************************************************************************/

package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.answer_questionnairedao;
import model.answer_questionnaire;

public class answer_questionnairedaoimpl extends HibernateDaoSupport implements answer_questionnairedao{

	@Override
	@SuppressWarnings("unchecked")
	public answer_questionnaire getAnswer_questionnaire(int userId, int questionnaireId) {
		List<answer_questionnaire> ans_ques = (List<answer_questionnaire>)getHibernateTemplate()
				.find("from answer_questionnaire as aq where aq.u_id=? and aq.q_id=?", userId, questionnaireId);
		if(ans_ques.isEmpty()){
			return null;
		}
		return ans_ques.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<answer_questionnaire> getAnswer_questionnaireByUser(int userId) {
		List<answer_questionnaire> ans_ques = (List<answer_questionnaire>)getHibernateTemplate()
				.find("from answer_questionnaire as aq where aq.u_id=?", userId);
		return ans_ques;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<answer_questionnaire> getAnswer_questionnaireByQues(int questionnaireId) {
		List<answer_questionnaire> ans_ques = (List<answer_questionnaire>)getHibernateTemplate()
				.find("from answer_questionnaire as aq where aq.q_id=?", questionnaireId);
		return ans_ques;
	}

	@Override
	public boolean saveAnswer_questionnaire(answer_questionnaire ans_ques) {
		answer_questionnaire ans_quesTemp = getAnswer_questionnaire(ans_ques.getU_id(), ans_ques.getQ_id());
		if(ans_quesTemp == null){
			getHibernateTemplate().save(ans_ques);
			return true;
		}
		return false; //if exists the rocord
	}

	@Override
	public boolean updateAnswer_questionnaire(answer_questionnaire ans_ques) {
		// not checked
		getHibernateTemplate().merge(ans_ques);
		return true;
	}

	@Override
	public boolean deleteAnswer_questionnaire(int UserId, int questionnaireId) {
		answer_questionnaire ans_ques = getAnswer_questionnaire(UserId, questionnaireId);
		if(ans_ques != null){
			getHibernateTemplate().delete(ans_ques);
			if(getAnswer_questionnaire(UserId, questionnaireId) == null){
				return true;
			}
		}
		return false; //not exist
	}

}
