package daoimpl;

import dao.questionnairedao;
import model.questionnaire;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class questionnairedaoimpl extends HibernateDaoSupport implements questionnairedao {

	@Override
	@SuppressWarnings("unchecked")
	public questionnaire getq(int id) {
		List<questionnaire> u=(List<questionnaire>) getHibernateTemplate()
				.find("from questionnaire as qu where qu.id=?",id);
		return u.get(0);
	}

	@Override
	public boolean setq(questionnaire q) {
		 int id=q.getId();
		 getHibernateTemplate().merge(q);
		 if(q==getq(id))return true;
		 return false;
	}

	@Override
	public boolean updateq(questionnaire q) {
		int id=q.getId();
		getHibernateTemplate().merge(q);
		questionnaire q_new=getq(id);
		if(q==q_new)return true;
		return false;
	}

	@Override
	public boolean deleteq(int id) {
		questionnaire qu=getq(id);//ÕÒµ½É¾³ýÄ¿±ê
		if(qu!=null){
		getHibernateTemplate().delete(qu);
		if(getq(id)==null)return true;
		}
		return false;
	}

}
