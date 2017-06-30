/********************************************************************************* 
 * 6.29 创建
 * 6.30 增加接口定义  getUserByUsername,getUserByPhone,getUserByEmail
 *********************************************************************************/

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
		
		//通过用户名查找用户
		public user getUserByUsername(String username);
		
		//通过手机号码查找用户
		public user getUserByPhone(String phone);
		
		//通过邮箱账号查找用户
		public user getUserByEmail(String email);
		
}
