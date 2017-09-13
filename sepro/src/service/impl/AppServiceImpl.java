/********************************************************************************
 * 7.3 ���崴���޸�ɾ���ʾ��޸��û���Ϣ��Ҫ��service��ӿڣ�δʵ�֣�
 * 7.18 �õ������ѷ����ʾ��service�ӿ�
 * 7.19 �����ʾ��service�ӿ�
 *******************************************************************************/

package service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import model.answer_questionnaire;
import model.answers;
import model.one_question;
import model.questionnaire;
import model.user;
import model.q_options;

import dao.answerdao;
import dao.one_questiondao;
import dao.q_optiondao;
import dao.questionnairedao;
import dao.userdao;
import dao.answer_questionnairedao;

import service.AppService;


public class AppServiceImpl implements AppService {
	
	private answerdao answerdao;
	private one_questiondao one_questiondao;
	private q_optiondao q_optiondao;
	private questionnairedao questionnairedao;
	private userdao userdao;
	private answer_questionnairedao answer_questionnairedao;
	
	
	//setterע��
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


	public questionnairedao getQuestionnairedao() {
		return questionnairedao;
	}


	public void setQuestionnairedao(questionnairedao questionnairedao) {
		this.questionnairedao = questionnairedao;
	}


	public userdao getUserdao() {
		return userdao;
	}


	public void setUserdao(userdao userdao) {
		this.userdao = userdao;
	}


	public answer_questionnairedao getAnswer_questionnairedao() {
		return answer_questionnairedao;
	}


	public void setAnswer_questionnairedao(answer_questionnairedao answer_questionnairedao) {
		this.answer_questionnairedao = answer_questionnairedao;
	}
	
	
	/**
	 * ��¼ 
	 * ����1������username��email��phone������2������
	 * ���ƥ��ɹ������ظ�user���û������ڻ����벻��ȷ����null
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

	
	/**
	 * ע��
	 * ������user,��action��ʱ������user���󣬰���username��phone��password
	 * �û����Ѵ��ڷ���-1��mail�Ѵ��ڷ���-2��phone�Ѵ��ڷ���-3��
	 * ע��ɹ�����1
	 * 
	 * */
	
	@Override
	public int register(user user) {
		
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String mailTemp = user.getMail();
		
		//���username�Ƿ����
		user oneUser = userdao.getUserByUsername(usernameTemp);
		if(oneUser != null){ //exists
			return -1;
		}
		
		//���mail�Ƿ����
		oneUser = userdao.getUserByEmail(mailTemp);
		if(oneUser != null){ //exists
			return -2;
		}
			
		//���phone�Ƿ����
		oneUser = userdao.getUserByPhone(phoneTemp);
		if(oneUser != null){ //exists
			return -3;
		}
		

		if(userdao.createuser(user) != 0){
			return 1;
		}
		
		return 0;
	}

	
	/**
	 * List<questionnaire> getQuesListCreated(int userId)
	 * �������û�id
	 * ���أ��û�������������questionnaire���ɵ�List
	 * ˵����������ǰ�ˡ��ʾ�㳡�������Ҵ������ʾ���չʾ�ʾ��������ͼ��
	 * */
	
	@Override
	public List<questionnaire> getQuesListCreated(int userId) {
		return questionnairedao.getQuesListByUser(userId);
	}

	
	/**
	 * questionnaire getQuesContent(int id);
	 * ������questionnaire.id
	 * ���أ���Ӧ��questionnaireʵ��
	 * ˵������Ҫ����questionnaire��one_question��q_options���ű�����questionnaire��
	 *       questions������Ҫ�����ʾ��Ӧ��������Ŀ���ɵ�List��ͬ��questions��options
	 *       ������Ҫ����question��Ӧ������ѡ��ɵ�List��������hibernateһ�Զ�ӳ��ʵ�֡�����
	 *       Ԥ�����༭����д�ʾ�
	 * */
	
	@Override
	public questionnaire getQuesContent(int id) {
		return questionnairedao.getq(id);
	}

	
	/**
	 * int saveQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�������������questionnaireʵ��id
	 * ˵����������questionnaireʵ�������а���questions�б�ÿ��questions����options��
	 *       ������questionnaire��id��one_question��id��q_id���Լ�q_options��q_id����Ҫ
	 *       ָ��������ʱ�ֱ�洢����Ӧ��table���ұ�֤�໥���������ڱ����ʾ�
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
		return questionnaireId;
	}

	
	/**
	 * int updateQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�����״̬���ɹ�����0��ʧ�ܷ���-1��
	 * ˵����������questionnaireʵ�������а���questions�б�ÿ��questions����options��
	 *       ������ʱ�ֱ�洢����Ӧ��table���ұ�֤�໥������<b><u><p>����Ӧ��List��:<p>
	 *       1. ������޸��Ѿ������ݿ��б����one_question����optionsʵ��������ȷ����ʵ��ӵ��
	 *       ��ȷ��id�� <q_id, title>��<p>2. ����������е�questionnairʵ�������ӵ�one_question
	 *       ��optionsʵ������֤��δ֪��fk��pkΪ0��գ�<p>3. �����ɾ���ѱ����one_question
	 *       ��optionsʵ��(�����Ѵ�����Ҫ�󲻱���)������(String)stem��(String)property����Ϊnull
	 *       </u></b><p>�����޸��ʾ�
	 * */
	
	@Override
	public int updateQuesContent(questionnaire ques) {
		int one_quesId;
		Iterator<one_question> it = ques.getQuestions().iterator();
		while(it.hasNext()){
		//for(one_question one_ques : ques.getQuestions()){
			one_question one_ques = it.next();
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
					one_questiondao.delo_q(one_ques.getId());
				}
			}
		}
		if(questionnairedao.updateq(ques)){
			return 0;
		}
		return -1;
	}

	
	/**
	 * void updateOptionSet(Set<q_options> optionSet, int quesId);
	 * <p>˵����<b>����Service��updateQuesContent()������ʵ�֣�action�㲻������øýӿڡ�
	 * @param optionSet ��Ҫ���µ�one_questionʵ��������options���ɵ�Set
	 * @param quesId one_questionʵ����id
	 * */
	
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
	 * ������questionnaireʵ��
	 * ���أ�ɾ��״̬���ɹ��򷵻�0��ʧ�ܷ���-1
	 * ˵����������questionnaire����ҪΪ������questionnaireʵ������������ֻӵ��
	 *       questionnaire��id��Ϊ�˽ӿ�ͳһ���Է�װ��questionnaire����ֻ��Ҫ��
	 *       questionnaire����ɾ�������������ݿ�CASCADEԼ��ʵ�֡�����ɾ���ʾ�
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

	
	/**
	 * user getUserInfo(int id);
	 * �������û�id
	 * ���أ���Ӧ��userʵ����ʧ�ܷ���null
	 * ˵���������û�id�����û������ء������û�����û���Ϣ��
	 * */
	
	@Override
	public user getUserInfo(int id) {
		return userdao.get_one(id);
	}

	
	/**
	 * int updateUserInfo(user user);
	 * ������userʵ��
	 * ���أ�����״̬���ɹ�����0��ʧ�ܷ���-1~-6��
	 * ˵���������û���Ϣ������Ҫ���´����������û��޸��û���Ϣ��
	 * */
	
	@Override
	public int updateUserInfo(user user) {
		
		int id = user.getId();
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String mailTemp = user.getMail();
		
		//���username�Ƿ����
		user oneUser = userdao.getUserByUsername(usernameTemp);
		if(oneUser != null && oneUser.getId() != id){ //exists
			return -1;
		}
		
		//���mail�Ƿ����
		oneUser = userdao.getUserByEmail(mailTemp);
		if(oneUser != null && oneUser.getId() != id){ //exists
			return -2;
		}
			
		//���phone�Ƿ����
		oneUser = userdao.getUserByPhone(phoneTemp);
		if(oneUser != null && oneUser.getId() != id){ //exists
			return -3;
		}
		
		if(userdao.updateuser(user) == true){
			return 0;
		}
		return 0;
	}

	
	/**
	 * List<answer_questionnaire> getQuesListFilled(int userId)
	 * �������û�id
	 * ���أ��û�����д������answer_questionnaire���ɵ�List
	 * ˵������answer_questionnaire��questionnaire�в��ң�List�д洢��Ӧ����������
	 *       answer_questionnaire��ʵ������answer_questionnaire��questionnaire����
	 *       ��Ҫ��Ϊnull��<p>������ǰ�ˡ�����д���ʾ���չʾ �ʾ��������ͼ��
	 * */
	
	@Override
	public List<answer_questionnaire> getQuesListFilled(int userId) {
		// �û���д��������answer_questionnaire
		List<answer_questionnaire> answer_questionnaireList = 
				answer_questionnairedao.getAnswer_questionnaireByUser(userId);
		
		answer_questionnaire ans_ques;
		questionnaire ques;
		Iterator<answer_questionnaire> it = answer_questionnaireList.iterator();
		while(it.hasNext()){
			//���ÿ��answer_questionnaire��questionnaire����
			ans_ques = it.next();
			ques = questionnairedao.getq(ans_ques.getQ_id());
			ans_ques.setQuestionnaire(ques);
		}
		
		return answer_questionnaireList;
	}

	
	/**
	 * answer_questionnaire getQuesContentFilled(int userId,int quesId);
	 * �������ʾ���д��userʵ����id���ʾ�questionnaireʵ����id
	 * ���أ�������answer_questionnaireʵ��
	 * ˵��������������answer_questionnaireʵ��������questionnaire��ansList���Բ�����
	 *       Ϊ�գ���questionnaireʵ���е�questions���Լ�one_questionʵ����options��
	 *       �Ծ�������Ϊ�ա������û��������д���ʾ�
	 * */
	
	@Override
	public answer_questionnaire getQuesContentFilled(int userId,int quesId) {
		
		answer_questionnaire ans_ques = answer_questionnairedao.getAnswer_questionnaire(userId, quesId);
		if(ans_ques == null){
			return null;
		}
		
		// ���questionnaire����
		questionnaire ques = questionnairedao.getq(ans_ques.getQ_id());
		ans_ques.setQuestionnaire(ques);
		
		// ���ansList����
		answers ans;
		for(one_question one_ques : ques.getQuestions()){
			ans = answerdao.getan(one_ques.getId(), userId);
			ans_ques.getAnsList().add(ans);
		}
		
		return ans_ques;
	}

	
	/**
	 * int saveAnswerList(List<answers> ansList);
	 * <p>��������answerʵ�����ɵ�ansList�б�
	 * <p>˵����<b>���ansList��ĳ��ʵ����answers�����Ѿ����ڣ�����¸�����¼�����û���򴴽�
	 *      answersʵ��������<u>��������</u>�û��Ĵ𰸡�<u>������action��ֱ�ӵ��á�</u>
	 * */
	
	@Override
	public void saveAnswerList(List<answers> ansList) {
		answers ansTemp;
		for(answers ans: ansList){
			ansTemp = answerdao.getan(ans.getO_id(), ans.getU_id());
			if(ansTemp == null){
				// not exist, save the answer object
				answerdao.setan(ans);
			} else {
				//exist, update the object
				answerdao.updatean(ans);
			}
		}
	}

	
	/**
	 * int saveAnsQuesContent(answer_questionnaire ansQuesRecord);
	 * <p>������answer_questionnaireʵ��
	 * <p>˵����<b>���������ǲ�������answer_questionnaireʵ������ֻ��Ҫӵ��q_id��u_id��
	 *      submit_time��if_complete���ԣ�����Ҫ��ansList���Բ�Ϊ�ա�questionnaire
	 *      ���Բ���Ҫ��ansList�о����answers���������saveAnswerList()�������档
	 *      ����<u>��������</u>�û���д�ʾ�����ݡ�
	 * */
	
	@Override
	public void saveAnsQuesContent(answer_questionnaire ansQuesContent) {
		
		answer_questionnaire ansQuesRecord = answer_questionnairedao
				.getAnswer_questionnaire(ansQuesContent.getU_id(), ansQuesContent.getQ_id());
		
		//check if exists
		if(ansQuesRecord == null){
			//not exist,save the answer_questionnaire object
			answer_questionnairedao.saveAnswer_questionnaire(ansQuesContent);
		} else{
			//exist, update
			answer_questionnairedao.updateAnswer_questionnaire(ansQuesContent);
		}
		
		//then save the answer List
		saveAnswerList(ansQuesContent.getAnsList());
	}

	
	/**
	 * int saveQuestionnaire(questionnaire ques);
	 * <p>������questionnaireʵ��
	 * <p>���أ����浽���ݿ�֮�󷵻ص�questionnaire.id
	 * <p>˵���������ǲ�������questionnaireʵ��������Ҫӵ��id��questions���Կ���Ϊ�ա�����
	 *         �����½����ʾ�
	 * **/
	
	@Override
	public int saveQuestionnaire(questionnaire ques) {
		return questionnairedao.setq(ques);
	}

	
	/**
	 * int saveQuestion(one_question one_ques);
	 * <p>������one_questionʵ��
	 * <p>���أ����浽���ݿ�֮�󷵻ص�one_question.id
	 * <p>˵��������Ϊ��������one_questionʵ��������Ҫ����id��options���Կ���Ϊ�ա�������
	 *         Ҫָ����Ӧ��questionnaire��id��q_id���ԡ����ڱ����½��ʾ��е���Ŀ��
	 * **/	
	
	@Override
	public int saveQuestion(one_question one_ques) {
		return one_questiondao.creo_q(one_ques);
	}

	
	/**
	 * void saveOption(q_options opt);
	 * <p>������q_optionsʵ��
	 * <p>˵����q_optionsû�����õ���������������Ҫ����ֵ�����ڱ����½��ʾ��е�ѡ�
	 * **/
	
	@Override
	public void saveOption(q_options opt) {
		q_optiondao.setqo(opt);	
	}


	/**
	 * List<questionnaire> getAllQuesListPublished();
	 * <p>���أ����ݿ��б������ѷ����������ʾ�
	 * <p>˵����set_time��Ϊnull��Ϊ�ѷ���������Ҫ��end_time��������ǰʱ�䡣�����ʾ�㳡��
	 * **/

	@Override
	public List<questionnaire> getAllQuesListPublished() {
		return questionnairedao.getAllQuesList();
	}
	
	
	/**
	 * boolean publishQuestionnaire(int questionnaireId, Date set_date, Date end_date);
	 * <p>������ (int)questionnaire.id, (java.util.Date)set_date, end_date
	 * <p>���أ� true if success, false if fail
	 * <p>˵��������set_date��end_date����Ϊ�ʾ��ѷ��������ڷ����ʾ�
	 * **/

	@Override
	public boolean publishQuestionnaire(int questionnaireId, Date set_date, Date end_date) {
		questionnaire ques = questionnairedao.getq(questionnaireId);
		ques.setSet_date(set_date);
		ques.setEnd_date(end_date);
		if(questionnairedao.updateq(ques)){
			return true;
		}
		return false;
	}


	/**
	 * user getUserTemp(String ip);
	 * <p>������(java.lang.String)ip,�ͻ���ip
	 * <p>���أ�ֻ��id��ip��Userʵ������Ϊ��ʱ�û���
	 * <p>˵������������δ��¼�û���д�ʾ�����
	 * **/
	
	@Override
	public user getUserTemp(String ip) {
		user userTemp = new user();
		userTemp.setIp(ip);
		int userId = userdao.createuser(userTemp);
		return userdao.get_one(userId);
	}


	/**
	 * boolean existIp(String ip);
	 *<p>������ip
	 *<p>���أ����ڷ���true�������ڷ���false
	 * **/
	
	@Override
	public boolean existIp(String ip) {
		if(userdao.getUserByIp(ip)!= null){
			return true;
		}
		return false;
	}


	/**
	 * List<answer_questionnaire> getAnsQuesListByQuestionnaire(int questionnaireId);
	 * ������questionnaire.id
	 * ���أ�ĳquestionnaire��Ӧ��answer_questionnaire���ɵ�List
	 * ˵����List�У�answer_questionnaire��questionnaire���Բ���Ҫ��䣬��ansList���Բ�Ϊ�ա�
	 * 		<p>�����ʾ�ͳ�ơ�
	 * */
	
	@Override
	public List<answer_questionnaire> getAnsQuesListByQuestionnaire(int questionnaireId) {
		List<answer_questionnaire>ansQuesList = answer_questionnairedao.getAnsQuesListByQuesId(questionnaireId);
		questionnaire questionnaire = questionnairedao.getq(questionnaireId);
		int userId, questionId;
		answers ans;
		//�Իش��¼�б��е�ÿһ����¼
		for(answer_questionnaire ansQues : ansQuesList){
			userId = ansQues.getU_id();
			//���ʾ��е�ÿ������
			for(one_question question : questionnaire.getQuestions()){
				questionId = question.getId();
				ans = answerdao.getan(questionId, userId);
				ansQues.getAnsList().add(ans);
			}
		}
		return ansQuesList;
	}


	/**
	 * String getDataDiagram(int questionId);
	 * <p>����������one_question��id
	 * <p>���أ�����diagram��·��������Ϊ�̶�·����
	 * <p>˵��������һ�����⣨ѡ���⣩�Ļش�ֲ�ͳ��ͼ
	 * **/
	
	@Override
	public String getDataDiagram(int questionId) {		
		one_question question=one_questiondao.geto_q(questionId);
		if(question.getType()==2)return null;//�����ֱ������
		String chartTitle=String.valueOf(question.getTitle_num())+"."+question.getStem();
		JFreeChart chart;
	
		List<answers> anslist=new ArrayList<answers>();
		anslist=answerdao.getAnsListByQuesId(questionId);//�õ����д�
	
		Map<String,Integer> ans_num=new HashMap<String,Integer>();
		//ʹ��һ��map<��ţ���ѡ����>�������д���Ϣ
		for(q_options option:question.getOptions()){
			ans_num.put(option.getTitle(),0);
		}//Ԥ���������б�ѡ����Ϊ0
		int new_num;
	
		if(question.getType()==0){//��ѡ��
		
			for(int i=0;i<anslist.size();i++){
				new_num=ans_num.get(anslist.get(i).getAnswer())+1;
				ans_num.put(anslist.get(i).getAnswer(),new_num);
			}//�ظ����±�ѡ����
			
			DefaultPieDataset dpd=new DefaultPieDataset();//��ʼ����ͼ
		
		for(Map.Entry<String, Integer> entry:ans_num.entrySet()){//����map
			for(q_options option:question.getOptions()){//ÿ��map�����ٱ�������ѡ��
				if(entry.getKey()==option.getTitle()){//��ѡ�����==map�е����
					dpd.setValue(option.getProperty(), entry.getValue());//����ͼ��ʱʹ����Ŀ����
				}
			}
		}
		
		chart=ChartFactory.createPieChart(chartTitle,dpd,true,false,false);
	}	
	else{//��ѡ��	
		
		for(int i=0;i<anslist.size();i++){
			for(int j=0;j<anslist.get(i).getAnswer().length();j++){
				new_num=ans_num.get(String.valueOf(anslist.get(i).getAnswer().charAt(j)))+1;
				ans_num.put(String.valueOf((anslist.get(i).getAnswer().charAt(j))), new_num);
			}
		}
		
		DefaultCategoryDataset dpd = new DefaultCategoryDataset();
		
		for(Map.Entry<String, Integer> entry:ans_num.entrySet()){//����map
			dpd.setValue(entry.getValue(), "1", entry.getKey());
		}
		
		chart=ChartFactory.createBarChart(chartTitle,"���", "����", dpd, PlotOrientation.VERTICAL, false,false,false);
	}
	FileOutputStream fos_jpg=null;
	String path = "D:\\Web Cache\\diagram_" + questionId +".jpg";
	try{
		fos_jpg=new FileOutputStream(path);
		ChartUtilities.writeChartAsJPEG(fos_jpg,0.7f,chart,640,480,null);
		fos_jpg.close();
	}catch(Exception e){
		e.printStackTrace();
	}
    	return path;
	}

	
	/**
	 * String getDataExcel(int questionnaireId);
	 * <p>��������Ҫ����������ʾ��id
	 * <p>���أ�����Excel�ļ���·�������Թ̶�·����
	 * <p>˵�������ɸ��ʾ���������𰸵�ͳ�ƽ��������getAnsListByQuestionnaire�ӿ�
	 * **/
	
	@Override
	public String getDataExcel(int questionnaireId) {
		
		questionnaire questionnaire = this.getQuesContent(questionnaireId);
		Object[] quesArray = questionnaire.getQuestions().toArray();
		List<answer_questionnaire> ansQuesList = this.getAnsQuesListByQuestionnaire(questionnaireId);
		
		// ��һ��������һ��webbook����Ӧһ��Excel�ļ�
		HSSFWorkbook wb = new HSSFWorkbook();
		// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		HSSFSheet sheet = wb.createSheet("�ش�ͳ��");
		
		// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		HSSFRow row = sheet.createRow(0);
		// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//���
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("���");
		cell.setCellStyle(style);
		
		one_question question;
		for(int j = 0; j < quesArray.length; j++){
			question = (one_question)quesArray[j];
			//��Ŀ����һ�У�
			int column = j + 1;//�ڶ��п�ʼ
			cell = row.createCell(column);
			cell.setCellValue(question.getTitle_num() + ". " + question.getStem());
			sheet.setColumnWidth(column, question.getStem().length()*600);
		}
		
		//���岽��д������
		answer_questionnaire ansQues;
		for(int i = 0; i < ansQuesList.size(); i++){
			ansQues = ansQuesList.get(i);
			int rownum = i + 1;//�ڶ��п�ʼ
			row = sheet.createRow(rownum);
			//д���һ�У���ţ�
			cell = row.createCell(0);
			cell.setCellValue(rownum);
			cell.setCellStyle(style);
			
			List<answers> ansList = ansQues.getAnsList();
			for(int j = 0; j < quesArray.length; j++){
				//��ѯ��ֵ����Ҫquestion��id��
				String ansValue = "";
				for(answers ans : ansList){
					if(ans.getO_id() == ((one_question)quesArray[j]).getId()){
						ansValue = ans.getAnswer();
					}
				}
				//д���
				int column = j + 1;//�ڶ��п�ʼ
				cell = row.createCell(column);
				cell.setCellValue(ansValue);
			}
		}
		
		//�������������ļ�
		String path = "D:\\Web Cache\\test.xls";
		try{
			FileOutputStream fStream = new FileOutputStream(path);
			wb.write(fStream);
			fStream.close();
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return path;
	}


	@Override
	public List<user> getAllUsers() {
		return userdao.getAllUsers();
	}


	@Override
	public void allowUser(int id) {
		user u=userdao.get_one(id);
		u.setAuthority(1);
		userdao.updateuser(u);
		
	}


	@Override
	public void deleteUser(int id) {
		userdao.deleteuser(id);
		
	}


	@Override
	public void forbidUser(int id) {
		user u=userdao.get_one(id);
		u.setAuthority(0);
		userdao.updateuser(u);
		
	}


	@Override
	public void assignadmin(int id) {
		user u=userdao.get_one(id);
		u.setRole(1);
		userdao.updateuser(u);
		
	}


	@Override
	public List<questionnaire> getAllQuesList() {
		return questionnairedao.getQuesList();
	}

}
