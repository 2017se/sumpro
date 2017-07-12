/********************************************************************************
 * 7.3 定义创建修改删除问卷、修改用户信息需要的service层接口
 *******************************************************************************/

package service;

import java.util.List;
import java.util.Set;

import model.user;
import model.answer_questionnaire;
import model.answers;
import model.one_question;
import model.q_options;
import model.questionnaire;

public interface AppService {

	
	/**
	 * 登录 
	 * 参数1可以是username，email或phone，参数2是密码
	 * 如果匹配成功，返回该user，用户不存在或密码不正确返回null
	 * */
	public user login(String username, String password);
	
	
	/**
	 * 注册
	 * 参数是user,是action临时创建的user对象，包含username，phone，password
	 * 用户名已存在返回-1，phone已存在返回-2
	 * 用户名不合法返回-3，phone不合法返回-4，密码不合法返回-5(判断是否合法可以先不实现）
	 * 注册成功返回1
	 * */
	public int register(user user);
	
	
	/**
	 * List<questionnaire> getQuesListCreated(int userId)
	 * 参数：用户id
	 * 返回：用户所创建的所有questionnaire构成的List
	 * 说明：用于在前端“问卷广场”、“我创建的问卷”中展示问卷简介或缩略图。
	 * */
	public List<questionnaire> getQuesListCreated(int userId);
	
	
	/**
	 * questionnaire getQuesContent(int id);
	 * 参数：questionnaire.id
	 * 返回：对应的questionnaire实例
	 * 说明：需要查找questionnaire，one_question，q_options三张表，并且questionnaire的
	 *       questions属性需要包含问卷对应的所有题目构成的List，同理questions的options
	 *       属性需要包含question对应的所有选项构成的List。具体由hibernate一对多映射实现。用于
	 *       预览、编辑、填写问卷。
	 * */
	public questionnaire getQuesContent(int id);
	
	
	/**
	 * int saveQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：保存状态（成功返回所创建的questionnaire实例id，失败返回-1）
	 * 说明：参数是questionnaire实例，其中包含questions列表，每个questions包含options列
	 *       表；其中questionnaire的id，one_question的id，q_id，以及q_options的q_id不需要
	 *       指定。保存时分别存储到对应的table并且保证相互关联。用于保存问卷。
	 * */
	public int saveQuesContent(questionnaire ques);
	
	
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
	public int updateQuesContent(questionnaire ques);
	
	
	/**
	 * int deleteQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：删除状态，成功则返回0，失败返回-1
	 * 说明：参数中questionnaire不需要为完整的questionnaire实例，甚至可以只拥有
	 *       questionnaire的id（为了接口统一所以封装成questionnaire）。只需要在
	 *       questionnaire表中删除，其余由数据库CASCADE约束实现。用于删除问卷。
	 * */
	public int deleteQuesContent(questionnaire ques);
	
	
	/**
	 * user getUserInfo(int id);
	 * 参数：用户id
	 * 返回：对应的user实例，失败返回null
	 * 说明：根据用户id查找用户并返回。用于用户浏览用户信息。
	 * */
	public user getUserInfo(int id);
	
	
	/**
	 * int updateUserInfo(user user);
	 * 参数：user实例
	 * 返回：更新状态（成功返回0，失败返回-1）
	 * 说明：更新用户信息，不需要重新创建。用于用户修改用户信息。
	 * */
	public int updateUserInfo(user user);
	
	
	/**
	 * List<answer_questionnaire> getQuesListFilled(int userId)
	 * 参数：用户id
	 * 返回：用户所填写的所有answer_questionnaire构成的List
	 * 说明：从answer_questionnaire和questionnaire中查找，List中存储的应该是完整的
	 *       answer_questionnaire的实例，即answer_questionnaire的questionnaire属性
	 *       需要不为null。但不需要包含题目和选项的内容，即answer_questionnaire的
	 *       questionnaire属性可以为不完整的实例。用于在前端“我填写的问卷”中展示问卷
	 *       简介或缩略图。
	 * */
	public List<answer_questionnaire> getQuesListFilled(int userId);
	
	
	/**
	 * answer_questionnaire getQuesContentFilled(int userId,int quesId);
	 * 参数：问卷填写者user实例的id和问卷questionnaire实例的id
	 * 返回：完整的answer_questionnaire实例
	 * 说明：返回完整的answer_questionnaire实例，其中questionnaire和ansList属性不允许
	 *       为空，且questionnaire实例中的questions属性及one_question实例的options属
	 *       性均不允许为空。用于用户浏览已填写的问卷。
	 * */
	public answer_questionnaire getQuesContentFilled(int userId,int quesId);
	
	
	/**
	 * int saveAnswerList(List<answers> ansList);
	 * <p>参数：由answer实例构成的ansList列表
	 * <p>说明：<b>如果ansList中某个实例在answers表中已经存在，则更新该条记录，如果没有则创建
	 *      answers实例。用于<u>保存或更新</u>用户的答案。<u>不建议action层直接调用。</u>
	 * */
	public void saveAnswerList(List<answers> ansList);
	
	
	/**
	 * int saveAnsQuesRecord(answer_questionnaire ansQuesRecord);
	 * <p>参数：answer_questionnaire实例
	 * <p>说明：<b>参数可以是不完整的answer_questionnaire实例，即只需要拥有q_id，u_id，
	 *      submit_time和if_complete属性，并且要求ansList属性不为空。questionnaire
	 *      属性不作要求。ansList中具体的answers内容需调用saveAnswerList()方法保存。
	 *      用于<u>保存或更新</u>用户填写问卷的内容。
	 * */
	 public void saveAnsQuesContent(answer_questionnaire ansQuesRecord);
	 
	 
	/**
	 * void updateOptionSet(Set<q_options> optionSet, int quesId);
	 * <p>说明：<b>用于Service层updateQuesContent()方法的实现，action层不建议调用该接口。
	 * @param optionSet 需要更新的one_question实例关联的options构成的Set
	 * @param quesId one_question实例的id
	 * */
	public void updateOptionSet(Set<q_options> optionSet, int quesId);
	
	
	/**
	 * int saveQuestionnaire(questionnaire ques);
	 * <p>参数：questionnaire实例
	 * <p>返回：保存到数据库之后返回的questionnaire.id
	 * <p>说明：参数是不完整的questionnaire实例，不需要拥有id且questions属性可以为空。用于
	 *         保存新建的问卷。
	 * **/
	public int saveQuestionnaire(questionnaire ques);
	
	
	/**
	 * int saveQuestion(one_question one_ques);
	 * <p>参数：one_question实例
	 * <p>返回：保存到数据库之后返回的one_question.id
	 * <p>说明：参数为不完整的one_question实例，不需要包含id且options属性可以为空。但是需
	 *         要指定对应的questionnaire的id即q_id属性。用于保存新建问卷中的题目。
	 * **/
	public int saveQuestion(one_question one_ques);
	
	/**
	 * void saveOption(q_options opt);
	 * <p>参数：q_options实例
	 * <p>说明：q_options没有设置单独的主键，不需要返回值。用于保存新建问卷中的选项。
	 * **/
	public void saveOption(q_options opt);
	
}
