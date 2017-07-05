/******************************************************************
 * 7.5  修改setqo的实现
 *        fix：使用List.get(0)前先检验是否为null
 ******************************************************************/

package daoimpl;

import dao.q_optiondao;
import model.q_options;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class q_optiondaoimpl extends HibernateDaoSupport  implements q_optiondao {


	@Override
	@SuppressWarnings("unchecked")
	public q_options getqo(int q_id, String title) {
		List<q_options> qo=(List<q_options>) getHibernateTemplate()
				.find("from q_options as qo where qo.q_id=? and qo.title=?",q_id,title);
		if(qo.isEmpty()){
			return null;
		}
		return qo.get(0);
	}

	@Override
	public boolean delqo(int q_id, String title) {
		q_options qo=getqo(q_id, title);//找到删除目标
		if(qo!=null){
		getHibernateTemplate().delete(qo);
		if(getqo(q_id,title)==null)return true;
		}
		return false;
	}

	@Override
	public boolean updateqo(q_options qo) {
		int id=qo.getQ_id();
		String title = qo.getTitle();
		getHibernateTemplate().merge(qo);
		q_options qo_new=getqo(id, title);
		if(qo==qo_new)
			return true;
		return false;
	}

	@Override
	public boolean setqo(q_options qo) {
		int old_id = qo.getQ_id();
		getHibernateTemplate().save(qo);
		getHibernateTemplate().flush();
		return (qo.getQ_id() == old_id);
	}

}
