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
	
	
	//setter注入
	
	public void setAnswerdao(answerdao answerdao) {
		this.answerdao = answerdao;
	}

	public void setOne_questiondao(one_questiondao one_questiondao) {
		this.one_questiondao = one_questiondao;
	}

	public void setQ_optiondao(q_optiondao q_optiondao) {
		this.q_optiondao = q_optiondao;
	}

	public void setQuestionnairedao(questionnairedao questionnairedao) {
		this.questionnairedao = questionnairedao;
	}

	public void setUserdao(userdao userdao){
		this.userdao = userdao;
	}
	
	
	/* 
	 * 登录 
	 * 参数1可以是username，email或phone，参数2是密码
	 * 如果匹配成功，返回该user，用户不存在或密码不正确返回null
	 */
	
	@Override
	public user login(String username, String password) {
		String identity = username;
		user userTemp;
		
		//identify is username
		if((userTemp = userdao.getUserByUsername(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword().equals(password)){
				return userTemp;
			}
			return null;
		}

		//identify is email
		if((userTemp = userdao.getUserByEmail(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword().equals(password)){
				return userTemp;
			}
			return null;
		}
		
		//identify is username
		if((userTemp = userdao.getUserByPhone(identity)) != null){
			//identity exists, then check password
			if(userTemp.getPassword().equals(password)){
				return userTemp;
			}
			return null;
		}
		return null;
	}

	/*
	 * 注册
	 * 参数是user,是action临时创建的user对象，包含username，phone，password
	 * 用户名已存在返回-1，phone已存在返回-2
	 * 用户名不合法返回-3，phone不合法返回-4，密码不合法返回-5(判断是否合法可以先不实现）
	 * 注册成功返回1
	 * 
	 */
	
	@Override
	public int register(user user) {
		
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String passwordTemp = user.getPassword();
		
		//检查username是否合法
		if(usernameTemp.length()> 20){
			//valid username in database: varchar(20)
			return -3;
		}
		
		//检查phone是否合法
		if(phoneTemp.length() != 11 && phoneTemp.charAt(0) != '1'){
			//valid phone in database: varchar(11)
			return -4;
		}
		
		//检查password是否合法
		if(passwordTemp.length() > 20){
			//valid password in database: varchar(20)
		}
		
		//检查username是否存在
		user oneUser = userdao.getUserByUsername(usernameTemp);
		if(oneUser != null){ //exists
			return -1;
		}
		
		//检查phone是否存在
		oneUser = userdao.getUserByPhone(phoneTemp);
		if(oneUser != null){ //exists
			return -2;
		}
		
		//保存user，以下内容注册时不填写，登录后可以修改
		user.setMail(null);
		user.setName(null);
		user.setQq(null);
		user.setRole(0); // 0是普通用户
		if(userdao.createuser(user)){
			return 1;
		}
		
		return 0;
	}

}
