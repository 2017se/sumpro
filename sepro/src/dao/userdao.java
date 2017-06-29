package dao;

import model.user;
public interface userdao {
		//获得一个user
		public user get_one(int userID);
		//删除user
		public boolean deleteuser(int userID);
		//更改user信息
		public boolean updateuser(user u);
		//创建一个user
		public boolean createuser(user u);
		
}
