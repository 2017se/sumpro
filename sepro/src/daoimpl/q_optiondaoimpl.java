package daoimpl;

import dao.q_optiondao;
import model.q_options;
import model.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class q_optiondaoimpl extends HibernateDaoSupport  implements q_optiondao {

	@Override
	public q_options getqo(int q_id) {
		List<q_options> qo=(List<q_options>) getHibernateTemplate().find("from q_options as qo where qo.q_id=?",q_id);
		return qo.get(0);
	}

	@Override
	public boolean delqo(int q_id) {
		q_options qo=getqo(q_id);//ÕÒµ½É¾³ýÄ¿±ê
		if(qo!=null){
		getHibernateTemplate().delete(qo);
		if(getqo(q_id)==null)return true;
		}
		return false;
	}

	@Override
	public boolean updateqo(q_options qo) {
		int id=qo.getQ_id();
		getHibernateTemplate().merge(qo);
		q_options qo_new=getqo(id);
		if(qo==qo_new)return true;
		return false;
	}

	@Override
	public boolean setqo(q_options qo) {
		int id=qo.getQ_id();
		 getHibernateTemplate().merge(qo);
		 if(qo==getqo(id))return true;
		 return false;
	}

}
