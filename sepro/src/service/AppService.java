package service;

import model.user;

public interface AppService {

	
	/* 
	 * ��¼ 
	 * ����1������username��email��phone������2������
	 * ���ƥ��ɹ������ظ�user���û������ڻ����벻��ȷ����null
	 */
	public user login(String username, String password);
	
	
	/*
	 * ע��
	 * ������user,��action��ʱ������user���󣬰���username��phone��password
	 * �û����Ѵ��ڷ���-1��phone�Ѵ��ڷ���-2
	 * �û������Ϸ�����-3��phone���Ϸ�����-4�����벻�Ϸ�����-5(�ж��Ƿ�Ϸ������Ȳ�ʵ�֣�
	 * ע��ɹ�����1
	 * 
	 */
	public int register(user user);
	
	
}
