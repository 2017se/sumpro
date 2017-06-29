package daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.userdao;
import model.user;

public class userdaoimpl extends HibernateDaoSupport implements userdao {

	@Override
	public user get_one(int userID) {
		List<user> u=(List<user>) getHibernateTemplate().find("from User as u where u.id=?",userID);
		return u.get(0);
	}

	@Override
	public boolean deleteuser(int userID) {
		user u=get_one(userID);//ÕÒµ½É¾³ıÄ¿±ê
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
		 int id=u.getId();
		 getHibernateTemplate().merge(u);
		 if(u==get_one(id))return true;
		 return false;
	}

}
