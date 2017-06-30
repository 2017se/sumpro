/********************************************************************************* 
 * 6.29 ����
 * 6.30 ���ӽӿڶ���  getUserByUsername,getUserByPhone,getUserByEmail
 *      �޸�createuser��ʵ�֣�user.id�����ݿⴴ����save֮ǰ����ʹ��getId��ԭʼ���룺
 *        > public boolean createuser(user u) {
		        int id=u.getId();
		        getHibernateTemplate().merge(u);
		        if(u==get_one(id))return true;
		        return false;
	        }
 *      �޸�hql�����USER->user[hql�﷨������POJO���������table]
 *      fix��ʹ��List.get(0)ǰ�ȼ����Ƿ�Ϊnull
 *********************************************************************************/

package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.userdao;
import model.user;


public class userdaoimpl extends HibernateDaoSupport implements userdao {

	@Override
	@SuppressWarnings("unchecked")
	public user get_one(int userID) {
		List<user> u=(List<user>) getHibernateTemplate()
				.find("from user as u where u.id=?",userID);
		if(u.isEmpty()){
			return null;
		}
		return u.get(0);
	}

	@Override
	public boolean deleteuser(int userID) {
		user u=get_one(userID);//�ҵ�ɾ��Ŀ��
		if(u!=null){
		getHibernateTemplate().delete(u);
		if(get_one(userID)==null)return true;
		}
		return false;
	}

	@Override
	public boolean updateuser(user u) {
		int id=u.getId();
		getHibernateTemplate().merge(u);
		user u_new=get_one(id);
		if(u==u_new)return true;
		return false;
	}

	@Override
	public boolean createuser(user u) {
		// ������û��Ƿ����,�ɱ����ú������
		getHibernateTemplate().save(u);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public user getUserByUsername(String username) {
		List<user> u=(List<user>) getHibernateTemplate()
				.find("from user as u where u.username=?",username);
		if(u.isEmpty()){
			return null;
		}
		return u.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public user getUserByPhone(String phone) {
		List<user> u=(List<user>) getHibernateTemplate()
				.find("from user as u where u.phone=?",phone);
		if(u.isEmpty()){
			return null;
		}
		return u.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public user getUserByEmail(String email) {
		List<user> u=(List<user>) getHibernateTemplate()
				.find("from user as u where u.mail=?",email);
		if(u.isEmpty()){
			return null;
		}
		return u.get(0);
	}

}
