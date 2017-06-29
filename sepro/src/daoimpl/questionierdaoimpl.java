package daoimpl;

import dao.questionierdao;
import model.questionier;
import model.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class questionierdaoimpl extends HibernateDaoSupport implements questionierdao {

	@Override
	public questionier getq(int id) {
		List<questionier> u=(List<questionier>) getHibernateTemplate().find("from questionier as qu where qu.id=?",id);
		return u.get(0);
	}

	@Override
	public boolean setq(questionier q) {
		 int id=q.getId();
		 getHibernateTemplate().merge(q);
		 if(q==getq(id))return true;
		 return false;
	}

	@Override
	public boolean updateq(questionier q) {
		int id=q.getId();
		getHibernateTemplate().merge(q);
		questionier q_new=getq(id);
		if(q==q_new)return true;
		return false;
	}

	@Override
	public boolean deleteq(int id) {
		questionier qu=getq(id);//ÕÒµ½É¾³ýÄ¿±ê
		if(qu!=null){
		getHibernateTemplate().delete(qu);
		if(getq(id)==null)return true;
		}
		return false;
	}

}
