package service.impl;

import model.user;

import dao.answerdao;
import dao.one_questiondao;
import dao.q_optiondao;
import dao.questionnairedao;
import dao.userdao;

import service.AppService;


public class AppServiceImpl implements AppService {
	
	private answerdao answerdao;
	private one_questiondao one_questiondao;
	private q_optiondao q_optiondao;
	private questionnairedao questionnairedao;
	private userdao userdao;
	
	//getter��setter���⼸��������û������Ҳ��֪��
	public answerdao getAnswerdao() {
		return answerdao;
	}

	public void setAnswerdao(answerdao answerdao) {
		this.answerdao = answerdao;
	}

	public one_questiondao getOne_questiondao() {
		return one_questiondao;
	}

	public void setOne_questiondao(one_questiondao one_questiondao) {
		this.one_questiondao = one_questiondao;
	}

	public q_optiondao getQ_optiondao() {
		return q_optiondao;
	}

	public void setQ_optiondao(q_optiondao q_optiondao) {
		this.q_optiondao = q_optiondao;
	}

	public questionnairedao getquestionnairedao() {
		return questionnairedao;
	}

	public void setquestionnairedao(questionnairedao questionnairedao) {
		this.questionnairedao = questionnairedao;
	}

	
	/* 
	 * ��¼ 
	 * ����1������username��email��phone������2������
	 * ���ƥ��ɹ������ظ�user���û������ڻ����벻��ȷ����null
	 */
	
	@Override
	public user login(String username, String password) {
		// TODO Auto-generated method stub
		String identity = username;
		user userTemp;
		
		//identify is username
		if((userTemp = userdao.getUserByUsername(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword() != password){
				return null;
			}
			return userTemp;
		}

		//identify is email
		if((userTemp = userdao.getUserByEmail(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword() != password){
				return null;
			}
			return userTemp;
		}
		
		//identify is username
		if((userTemp = userdao.getUserByPhone(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword() != password){
				return null;
			}
			return userTemp;
		}
		return null;
	}

	/*
	 * ע��
	 * ������user,��action��ʱ������user���󣬰���username��phone��password
	 * �û����Ѵ��ڷ���-1��phone�Ѵ��ڷ���-2
	 * �û������Ϸ�����-3��phone���Ϸ�����-4�����벻�Ϸ�����-5(�ж��Ƿ�Ϸ������Ȳ�ʵ�֣�
	 * ע��ɹ�����1
	 * 
	 */
	
	@Override
	public int register(user user) {
		
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String passwordTemp = user.getPassword();
		
		//���username�Ƿ�Ϸ�
		if(usernameTemp.length()> 20){
			//valid username in database: varchar(20)
			return -3;
		}
		
		//���phone�Ƿ�Ϸ�
		if(phoneTemp.length() != 11 && phoneTemp.charAt(0) != '1'){
			//valid phone in database: varchar(11)
			return -4;
		}
		
		//���password�Ƿ�Ϸ�
		if(passwordTemp.length() > 20){
			//valid password in database: varchar(20)
		}
		
		//���username�Ƿ����
		user oneUser = userdao.getUserByUsername(usernameTemp);
		if(oneUser != null){ //exists
			return -1;
		}
		
		//���phone�Ƿ����
		oneUser = userdao.getUserByPhone(phoneTemp);
		if(oneUser != null){ //exists
			return -2;
		}
		
		//����user����������ע��ʱ����д����¼������޸�
		user.setMail(null);
		user.setName(null);
		user.setQq(null);
		user.setRole(0); // 0����ͨ�û�
		if(userdao.createuser(user)){
			return 1;
		}
		
		return 0;
	}

}
