/********************************************************************************
 * 7.3 定义创建修改删除问卷、修改用户信息需要的service层接口（未实现）
 *******************************************************************************/

package service.impl;

import model.answer_questionnaire;
import model.answers;
import model.one_question;
import model.questionnaire;
import model.user;
import model.q_options;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * */
	
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
	 * 用户名已存在返回-1，phone已存在返回-2，mail已存在返回-3
	 * 注册成功返回1
	 * 
	 * */
	
	@Override
	public int register(user user) {
		
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String mailTemp = user.getMail();
		
		
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
		
		//检查mail是否存在
		oneUser = userdao.getUserByEmail(mailTemp);
		if(oneUser != null){ //exists
			return -3;
		}
		
		if(userdao.createuser(user)){
			return 1;
		}
		
		return 0;
	}

	
	/**
	 * List<questionnaire> getQuesListCreated(int userId)
	 * 参数：用户id
	 * 返回：用户所创建的所有questionnaire构成的List
	 * 说明：用于在前端“问卷广场”、“我创建的问卷”中展示问卷简介或缩略图。
	 * */
	
	@Override
	public List<questionnaire> getQuesListCreated(int userId) {
		return questionnairedao.getQuesListByUser(userId);
	}

	
	/**
	 * questionnaire getQuesContent(int id);
	 * 参数：questionnaire.id
	 * 返回：对应的questionnaire实例
	 * 说明：需要查找questionnaire，one_question，q_options三张表，并且questionnaire的
	 *       questions属性需要包含问卷对应的所有题目构成的List，同理questions的options
	 *       属性需要包含question对应的所有选项构成的List。具体由hibernate一对多映射实现。用于
	 *       预览、编辑、填写问卷。
	 * */
	
	@Override
	public questionnaire getQuesContent(int id) {
		return questionnairedao.getq(id);
	}

	
	/**
	 * int saveQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：保存状态（成功返回所创建的questionnaire实例id，失败返回-1）
	 * 说明：参数是questionnaire实例，其中包含questions列表，每个questions包含options列
	 *       表；其中questionnaire的id，one_question的id，q_id，以及q_options的q_id不需要
	 *       指定。保存时分别存储到对应的table并且保证相互关联。用于保存问卷。
	 * */
	
	@Override
	public int saveQuesContent(questionnaire questionnaireTemp) {
		
		int questionnaireId = questionnairedao.setq(questionnaireTemp);
		int one_questionId;
		
		for(one_question questionTemp : questionnaireTemp.getQuestions()){
			questionTemp.setQ_id(questionnaireId);
			one_questionId = one_questiondao.creo_q(questionTemp);
			
			for(q_options option : questionTemp.getOptions()){
				
				option.setQ_id(one_questionId);
				q_optiondao.setqo(option);
			}
		}

		return 0;
		

	}

	
	/**
	 * int updateQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：更新状态（成功返回0，失败返回-1）
	 * 说明：参数是questionnaire实例，其中包含questions列表，每个questions包含options列
	 *       表，保存时分别存储到对应的table并且保证相互关联。<b><u><p>在相应的List中:<p>
	 *       1. 如果是修改已经在数据库中保存的one_question或者options实例，必须确保该实例拥有
	 *       正确的id或 <q_id, title>；<p>2. 如果是在已有的questionnair实例上增加的one_question
	 *       或options实例，保证其未知的fk和pk为0或空；<p>3. 如果是删除已保存的one_question
	 *       或options实例(或者已创建但要求不保存)，设置(String)stem或(String)property属性为null
	 *       </u></b><p>用于修改问卷。
	 * */
	
	@Override
	public int updateQuesContent(questionnaire ques) {
		int one_quesId;
		Iterator<one_question> it = ques.getQuestions().iterator();
		while(it.hasNext()){
		//for(one_question one_ques : ques.getQuestions()){
			one_question one_ques = it.next();
			System.out.println(one_ques.getId());
			one_question one_quesTemp = one_questiondao.geto_q(one_ques.getId());
			if(one_quesTemp == null){
				//object not exist in database
				if(one_ques.getStem() != null){
					//object should be created
					one_ques.setQ_id(ques.getId());
					one_quesId = one_questiondao.creo_q(one_ques);
					// then update options
					updateOptionSet(one_ques.getOptions(), one_quesId);
				} else{
					//ignore: object is created but do not need store
					it.remove();
				}
			} else {
				//question object exists
				if(one_ques.getStem()  !=null){
					//first update options
					updateOptionSet(one_ques.getOptions(), one_ques.getId());
					//then update questions
					one_questiondao.updateo_q(one_ques);
				} else {
					//TODO delete
					one_questiondao.delo_q(one_ques.getId());
				}
			}
		}
		if(questionnairedao.updateq(ques)){
			return 0;
		}
		return -1;
	}

	@Override
	 public void updateOptionSet(Set<q_options> optionSet, int quesId) {
		Iterator<q_options> it = optionSet.iterator();
		while(it.hasNext()){
		//for(q_options opt : optionSet){
			q_options opt = it.next();
			q_options optTemp = q_optiondao.getqo(opt.getQ_id(), opt.getTitle());
			if(optTemp == null){
				//option object not exist in database
				if(opt.getProperty() != null){
					//option object should be created
					opt.setQ_id(quesId);
					q_optiondao.setqo(opt);
				} 
				else {
					//ignore: option object is created but do not need store
					it.remove();
				}
			} else {
				//option object exists
				if(opt.getProperty() != null){
					//update
					q_optiondao.updateqo(opt);
				} else {
					//delete
					q_optiondao.delqo(opt.getQ_id(), opt.getTitle());
				}
			}
		}
		 
	 }
	
	/**
	 * int deleteQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：删除状态，成功则返回0，失败返回-1
	 * 说明：参数中questionnaire不需要为完整的questionnaire实例，甚至可以只拥有
	 *       questionnaire的id（为了接口统一所以封装成questionnaire）。只需要在
	 *       questionnaire表中删除，其余由数据库CASCADE约束实现。用于删除问卷。
	 * */
	
	@Override
	public int deleteQuesContent(questionnaire ques) {
		int id = ques.getId();
		if(questionnairedao.deleteq(id)){
			return 0;
		} else {
			return -1;
		}
	}

	/*
	 * user getUserInfo(int id);
	 * 参数：用户id
	 * 返回：对应的user实例，失败返回null
	 * 说明：根据用户id查找用户并返回。用于用户浏览用户信息。
	 * */
	@Override
	public user getUserInfo(int id) {
		return userdao.get_one(id);
	}

	/*
	 * int updateUserInfo(user user);
	 * 参数：user实例
	 * 返回：更新状态（成功返回0，失败返回-1）
	 * 说明：更新用户信息，不需要重新创建。用于用户修改用户信息。
	 * */
	@Override
	public int updateUserInfo(user user) {
		if(userdao.updateuser(user) == true){
			return 0;
		}
		return -1;
	}

	@Override
	public List<answer_questionnaire> getQuesListFilled(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public answer_questionnaire getQuesContentFilled(int userId,int quesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveAnswerList(List<answers> ansList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveAnsQuesRecord(answer_questionnaire ansQuesRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
