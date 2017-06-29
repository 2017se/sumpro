package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.answerdao;

import model.answers;

public class answerdaoimpl extends HibernateDaoSupport implements answerdao {
	
	@Override
	@SuppressWarnings("unchecked")
	public answers getan(int o_id, int u_id){
		List<answers> ans =(List<answers>) getHibernateTemplate()
				.find("from ANSWERS as ans where ans.o_id=? and ans.u_id=?", o_id, u_id);
		return ans.get(0);
	}

	@Override
	public boolean setan(answers an) {
		return (boolean) getHibernateTemplate().save(an);
	}

	@Override
	public boolean deletean(int o_id, int u_id) {
		answers an = getan(o_id, u_id);
		if(an != null){ //object exists
			getHibernateTemplate().delete(an);
			if(getan(o_id,u_id)==null)
				return true;
		}
		return false;
	}

	@Override
	public boolean updatean(answers an) {
		// 没有检查是否update成功，直接返回true
		getHibernateTemplate().merge(an);
		return true;
	}
}
