/********************************************************************************* 
 * 6.29 ����
 * 6.30 ���ӽӿڶ���  getUserByUsername,getUserByPhone,getUserByEmail
 * 9.9  �޸�createuserʹ�䷵��id(int)
 *********************************************************************************/

package dao;

import java.util.List;

import model.user;

public interface userdao {
	
		//���һ��user
		public user get_one(int userID);
		
		//ɾ��user
		public boolean deleteuser(int userID);
		
		//����user��Ϣ
		public boolean updateuser(user u);
		
		//����һ��user,������User��id
		public int createuser(user u);
		
		//ͨ���û��������û�
		public user getUserByUsername(String username);
		
		//ͨ���ֻ���������û�
		public user getUserByPhone(String phone);
		
		//ͨ�������˺Ų����û�
		public user getUserByEmail(String email);
		
		//ͨ��ip�����û�
		public user getUserByIp(String ip);

		public List<user> getAllUsers();
		
}
