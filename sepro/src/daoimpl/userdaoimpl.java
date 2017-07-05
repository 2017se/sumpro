/********************************************************************************* 
 * 6.29 创建
 * 6.30 增加接口定义  getUserByUsername,getUserByPhone,getUserByEmail
 *      修改createuser的实现：user.id由数据库创建，save之前不能使用getId，原始代码：
 *        > public boolean createuser(user u) {
		        int id=u.getId();
		        getHibernateTemplate().merge(u);
		        if(u==get_one(id))return true;
		        return false;
	        }
 *      修改hql语句中USER->user[hql语法里面是POJO对象而不是table]
 *      fix：使用List.get(0)前先检验是否为null
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
		user u=get_one(userID);//找到删除目标
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
		// 不检查用户是否存在,由被调用函数检查
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
