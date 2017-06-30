/********************************************************************************* 
 * 6.29 ����
 * 6.30 ���ӽӿڶ���  getUserByUsername,getUserByPhone,getUserByEmail
 *********************************************************************************/

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
		
		//ͨ���û��������û�
		public user getUserByUsername(String username);
		
		//ͨ���ֻ���������û�
		public user getUserByPhone(String phone);
		
		//ͨ�������˺Ų����û�
		public user getUserByEmail(String email);
		
}
