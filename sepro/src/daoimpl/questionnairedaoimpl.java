/******************************************************************
 * 7.4 添加方法getQuesListByUser（根据userID查找问卷）
 * 7.5  修改setq的实现：questionnaire.id由数据库创建，save之前不能使用getId
 *         fix：使用List.get(0)前先检验是否为null
 * 7.18 添加方法getAllQuesList，查找已发布问卷
 ******************************************************************/

package daoimpl;

import dao.questionnairedao;
import model.questionnaire;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class questionnairedaoimpl extends HibernateDaoSupport implements questionnairedao {

	@Override
	@SuppressWarnings("unchecked")
	public questionnaire getq(int id) {
		List<questionnaire> u=(List<questionnaire>) getHibernateTemplate()
				.find("from questionnaire as qu where qu.id=?",id);
		if(u.isEmpty()){
			return null;
		}
		return u.get(0);
	}

	@Override
	public int setq(questionnaire q) {
		
		 getHibernateTemplate().save(q);
		 getHibernateTemplate().flush();
		 return q.getId();
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
		questionnaire qu=getq(id);//找到删除目标
		if(qu != null){
			getHibernateTemplate().delete(qu);
			if(getq(id) == null)
				return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<questionnaire> getQuesListByUser(int userId) {
		List<questionnaire> quesList = (List<questionnaire>) getHibernateTemplate()
				.find("from questionnaire as ques where ques.u_id=?",userId);
		return quesList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<questionnaire> getAllQuesList() {
		Date currentTime = new Date();
		String query = "from questionnaire as ques where "
				+ "ques.set_date <= :paramTime and "
				+ "ques.end_date >= :paramTime";
		List<questionnaire> quesList = (List<questionnaire>)getHibernateTemplate()
				.findByNamedParam(query, "paramTime", currentTime);
		return quesList;
	}

}
