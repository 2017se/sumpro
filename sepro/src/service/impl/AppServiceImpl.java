/********************************************************************************
 * 7.3 定义创建修改删除问卷、修改用户信息需要的service层接口（未实现）
 * 7.18 得到所有已发布问卷的service接口
 * 7.19 发布问卷的service接口
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
	
	
	//setter注入
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

	
	/**
	 * 注册
	 * 参数是user,是action临时创建的user对象，包含username，phone，password
	 * 用户名已存在返回-1，mail已存在返回-2，phone已存在返回-3，
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
		
		//检查mail是否存在
		oneUser = userdao.getUserByEmail(mailTemp);
		if(oneUser != null){ //exists
			return -2;
		}
			
		//检查phone是否存在
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
	 * 返回：返回所创建的questionnaire实例id
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
		return questionnaireId;
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
	 * <p>说明：<b>用于Service层updateQuesContent()方法的实现，action层不建议调用该接口。
	 * @param optionSet 需要更新的one_question实例关联的options构成的Set
	 * @param quesId one_question实例的id
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

	
	/**
	 * user getUserInfo(int id);
	 * 参数：用户id
	 * 返回：对应的user实例，失败返回null
	 * 说明：根据用户id查找用户并返回。用于用户浏览用户信息。
	 * */
	
	@Override
	public user getUserInfo(int id) {
		return userdao.get_one(id);
	}

	
	/**
	 * int updateUserInfo(user user);
	 * 参数：user实例
	 * 返回：更新状态（成功返回0，失败返回-1~-6）
	 * 说明：更新用户信息，不需要重新创建。用于用户修改用户信息。
	 * */
	
	@Override
	public int updateUserInfo(user user) {
		
		int id = user.getId();
		String usernameTemp = user.getUsername();
		String phoneTemp = user.getPhone();
		String mailTemp = user.getMail();
		
		//检查username是否存在
		user oneUser = userdao.getUserByUsername(usernameTemp);
		if(oneUser != null && oneUser.getId() != id){ //exists
			return -1;
		}
		
		//检查mail是否存在
		oneUser = userdao.getUserByEmail(mailTemp);
		if(oneUser != null && oneUser.getId() != id){ //exists
			return -2;
		}
			
		//检查phone是否存在
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
	 * 参数：用户id
	 * 返回：用户所填写的所有answer_questionnaire构成的List
	 * 说明：从answer_questionnaire和questionnaire中查找，List中存储的应该是完整的
	 *       answer_questionnaire的实例，即answer_questionnaire的questionnaire属性
	 *       需要不为null。<p>用于在前端“我填写的问卷”中展示 问卷简介或缩略图。
	 * */
	
	@Override
	public List<answer_questionnaire> getQuesListFilled(int userId) {
		// 用户填写过的所有answer_questionnaire
		List<answer_questionnaire> answer_questionnaireList = 
				answer_questionnairedao.getAnswer_questionnaireByUser(userId);
		
		answer_questionnaire ans_ques;
		questionnaire ques;
		Iterator<answer_questionnaire> it = answer_questionnaireList.iterator();
		while(it.hasNext()){
			//填充每个answer_questionnaire的questionnaire属性
			ans_ques = it.next();
			ques = questionnairedao.getq(ans_ques.getQ_id());
			ans_ques.setQuestionnaire(ques);
		}
		
		return answer_questionnaireList;
	}

	
	/**
	 * answer_questionnaire getQuesContentFilled(int userId,int quesId);
	 * 参数：问卷填写者user实例的id和问卷questionnaire实例的id
	 * 返回：完整的answer_questionnaire实例
	 * 说明：返回完整的answer_questionnaire实例，其中questionnaire和ansList属性不允许
	 *       为空，且questionnaire实例中的questions属性及one_question实例的options属
	 *       性均不允许为空。用于用户浏览已填写的问卷。
	 * */
	
	@Override
	public answer_questionnaire getQuesContentFilled(int userId,int quesId) {
		
		answer_questionnaire ans_ques = answer_questionnairedao.getAnswer_questionnaire(userId, quesId);
		if(ans_ques == null){
			return null;
		}
		
		// 填充questionnaire属性
		questionnaire ques = questionnairedao.getq(ans_ques.getQ_id());
		ans_ques.setQuestionnaire(ques);
		
		// 填充ansList属性
		answers ans;
		for(one_question one_ques : ques.getQuestions()){
			ans = answerdao.getan(one_ques.getId(), userId);
			ans_ques.getAnsList().add(ans);
		}
		
		return ans_ques;
	}

	
	/**
	 * int saveAnswerList(List<answers> ansList);
	 * <p>参数：由answer实例构成的ansList列表
	 * <p>说明：<b>如果ansList中某个实例在answers表中已经存在，则更新该条记录，如果没有则创建
	 *      answers实例。用于<u>保存或更新</u>用户的答案。<u>不建议action层直接调用。</u>
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
	 * <p>参数：answer_questionnaire实例
	 * <p>说明：<b>参数可以是不完整的answer_questionnaire实例，即只需要拥有q_id，u_id，
	 *      submit_time和if_complete属性，并且要求ansList属性不为空。questionnaire
	 *      属性不作要求。ansList中具体的answers内容需调用saveAnswerList()方法保存。
	 *      用于<u>保存或更新</u>用户填写问卷的内容。
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
	 * <p>参数：questionnaire实例
	 * <p>返回：保存到数据库之后返回的questionnaire.id
	 * <p>说明：参数是不完整的questionnaire实例，不需要拥有id且questions属性可以为空。用于
	 *         保存新建的问卷。
	 * **/
	
	@Override
	public int saveQuestionnaire(questionnaire ques) {
		return questionnairedao.setq(ques);
	}

	
	/**
	 * int saveQuestion(one_question one_ques);
	 * <p>参数：one_question实例
	 * <p>返回：保存到数据库之后返回的one_question.id
	 * <p>说明：参数为不完整的one_question实例，不需要包含id且options属性可以为空。但是需
	 *         要指定对应的questionnaire的id即q_id属性。用于保存新建问卷中的题目。
	 * **/	
	
	@Override
	public int saveQuestion(one_question one_ques) {
		return one_questiondao.creo_q(one_ques);
	}

	
	/**
	 * void saveOption(q_options opt);
	 * <p>参数：q_options实例
	 * <p>说明：q_options没有设置单独的主键，不需要返回值。用于保存新建问卷中的选项。
	 * **/
	
	@Override
	public void saveOption(q_options opt) {
		q_optiondao.setqo(opt);	
	}


	/**
	 * List<questionnaire> getAllQuesListPublished();
	 * <p>返回：数据库中保存且已发布的所有问卷
	 * <p>说明：set_time不为null即为已发布，并且要求end_time不超过当前时间。用于问卷广场。
	 * **/

	@Override
	public List<questionnaire> getAllQuesListPublished() {
		return questionnairedao.getAllQuesList();
	}
	
	
	/**
	 * boolean publishQuestionnaire(int questionnaireId, Date set_date, Date end_date);
	 * <p>参数： (int)questionnaire.id, (java.util.Date)set_date, end_date
	 * <p>返回： true if success, false if fail
	 * <p>说明：设置set_date和end_date即认为问卷已发布。用于发布问卷。
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
	 * <p>参数：(java.lang.String)ip,客户端ip
	 * <p>返回：只含id和ip的User实例（作为临时用户）
	 * <p>说明：用于区分未登录用户填写问卷的情况
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
	 *<p>参数：ip
	 *<p>返回：存在返回true，不存在返回false
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
	 * 参数：questionnaire.id
	 * 返回：某questionnaire对应的answer_questionnaire构成的List
	 * 说明：List中，answer_questionnaire的questionnaire属性不需要填充，但ansList属性不为空。
	 * 		<p>用于问卷统计。
	 * */
	
	@Override
	public List<answer_questionnaire> getAnsQuesListByQuestionnaire(int questionnaireId) {
		List<answer_questionnaire>ansQuesList = answer_questionnairedao.getAnsQuesListByQuesId(questionnaireId);
		questionnaire questionnaire = questionnairedao.getq(questionnaireId);
		int userId, questionId;
		answers ans;
		//对回答记录列表中的每一条记录
		for(answer_questionnaire ansQues : ansQuesList){
			userId = ansQues.getU_id();
			//对问卷中的每个问题
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
	 * <p>参数：问题one_question的id
	 * <p>返回：生成diagram的路径（可以为固定路径）
	 * <p>说明：生成一个问题（选择题）的回答分布统计图
	 * **/
	
	@Override
	public String getDataDiagram(int questionId) {		
		one_question question=one_questiondao.geto_q(questionId);
		if(question.getType()==2)return null;//填空题直接跳过
		String chartTitle=String.valueOf(question.getTitle_num())+"."+question.getStem();
		JFreeChart chart;
	
		List<answers> anslist=new ArrayList<answers>();
		anslist=answerdao.getAnsListByQuesId(questionId);//得到所有答案
	
		Map<String,Integer> ans_num=new HashMap<String,Integer>();
		//使用一个map<题号，被选次数>保存所有答案信息
		for(q_options option:question.getOptions()){
			ans_num.put(option.getTitle(),0);
		}//预先设置所有被选次数为0
		int new_num;
	
		if(question.getType()==0){//单选题
		
			for(int i=0;i<anslist.size();i++){
				new_num=ans_num.get(anslist.get(i).getAnswer())+1;
				ans_num.put(anslist.get(i).getAnswer(),new_num);
			}//重复更新被选次数
			
			DefaultPieDataset dpd=new DefaultPieDataset();//初始化饼图
		
		for(Map.Entry<String, Integer> entry:ans_num.entrySet()){//遍历map
			for(q_options option:question.getOptions()){//每次map集合再遍历问题选项
				if(entry.getKey()==option.getTitle()){//若选项题号==map中的题号
					dpd.setValue(option.getProperty(), entry.getValue());//创建图例时使用题目内容
				}
			}
		}
		
		chart=ChartFactory.createPieChart(chartTitle,dpd,true,false,false);
	}	
	else{//多选题	
		
		for(int i=0;i<anslist.size();i++){
			for(int j=0;j<anslist.get(i).getAnswer().length();j++){
				new_num=ans_num.get(String.valueOf(anslist.get(i).getAnswer().charAt(j)))+1;
				ans_num.put(String.valueOf((anslist.get(i).getAnswer().charAt(j))), new_num);
			}
		}
		
		DefaultCategoryDataset dpd = new DefaultCategoryDataset();
		
		for(Map.Entry<String, Integer> entry:ans_num.entrySet()){//遍历map
			dpd.setValue(entry.getValue(), "1", entry.getKey());
		}
		
		chart=ChartFactory.createBarChart(chartTitle,"题号", "数量", dpd, PlotOrientation.VERTICAL, false,false,false);
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
	 * <p>参数：需要导出结果的问卷的id
	 * <p>返回：生成Excel文件的路径（可以固定路径）
	 * <p>说明：生成该问卷所有问题答案的统计结果，调用getAnsListByQuestionnaire接口
	 * **/
	
	@Override
	public String getDataExcel(int questionnaireId) {
		
		questionnaire questionnaire = this.getQuesContent(questionnaireId);
		Object[] quesArray = questionnaire.getQuestions().toArray();
		List<answer_questionnaire> ansQuesList = this.getAnsQuesListByQuestionnaire(questionnaireId);
		
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("回答统计");
		
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//序号
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);
		
		one_question question;
		for(int j = 0; j < quesArray.length; j++){
			question = (one_question)quesArray[j];
			//题目（第一行）
			int column = j + 1;//第二列开始
			cell = row.createCell(column);
			cell.setCellValue(question.getTitle_num() + ". " + question.getStem());
			sheet.setColumnWidth(column, question.getStem().length()*600);
		}
		
		//第五步，写入数据
		answer_questionnaire ansQues;
		for(int i = 0; i < ansQuesList.size(); i++){
			ansQues = ansQuesList.get(i);
			int rownum = i + 1;//第二行开始
			row = sheet.createRow(rownum);
			//写入第一列（序号）
			cell = row.createCell(0);
			cell.setCellValue(rownum);
			cell.setCellStyle(style);
			
			List<answers> ansList = ansQues.getAnsList();
			for(int j = 0; j < quesArray.length; j++){
				//查询答案值（需要question的id）
				String ansValue = "";
				for(answers ans : ansList){
					if(ans.getO_id() == ((one_question)quesArray[j]).getId()){
						ansValue = ans.getAnswer();
					}
				}
				//写入答案
				int column = j + 1;//第二列开始
				cell = row.createCell(column);
				cell.setCellValue(ansValue);
			}
		}
		
		//第六步，保存文件
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
