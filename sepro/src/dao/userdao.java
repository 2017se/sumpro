package dao;

import model.user;
public interface userdao {
		//���һ��user
		public user get_one(int userID);
		//ɾ��user
		public boolean deleteuser(int userID);
		//����user��Ϣ
		public boolean updateuser(user u);
		//����һ��user
		public boolean createuser(user u);
		
}
