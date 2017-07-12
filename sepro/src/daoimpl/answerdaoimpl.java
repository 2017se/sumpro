/********************************************************************************* 
 * 6.30 �޸�hql�����ANSWERS->answers[hql�﷨������POJO���������table]
 *********************************************************************************/

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
				.find("from answers as ans where ans.o_id=? and ans.u_id=?", o_id, u_id);
		if(ans.isEmpty()){
			return null;
		}
		return ans.get(0);
	}

	@Override
	public boolean setan(answers an) {
		getHibernateTemplate().save(an);
		return true;
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
		// û�м���Ƿ�update�ɹ���ֱ�ӷ���true
		getHibernateTemplate().merge(an);
		return true;
	}
}
