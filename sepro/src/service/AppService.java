/********************************************************************************
 * 7.3 定义创建修改删除问卷、修改用户信息需要的service层接口
 *******************************************************************************/

package service;

import java.util.List;

import model.user;
import model.questionnaire;

public interface AppService {

	
	/* 
	 * 登录 
	 * 参数1可以是username，email或phone，参数2是密码
	 * 如果匹配成功，返回该user，用户不存在或密码不正确返回null
	 * */
	public user login(String username, String password);
	
	
	/*
	 * 注册
	 * 参数是user,是action临时创建的user对象，包含username，phone，password
	 * 用户名已存在返回-1，phone已存在返回-2
	 * 用户名不合法返回-3，phone不合法返回-4，密码不合法返回-5(判断是否合法可以先不实现）
	 * 注册成功返回1
	 * */
	public int register(user user);
	
	
	/*
	 * List<questionnaire> getQuesListCreated(int userId)
	 * 参数：用户id
	 * 返回：用户所创建的所有questionnaire构成的List
	 * 说明：只从questionnaire一张表中查找即可，questionnaire的questions属性应该为null。
	 *       用于在前端“问卷广场”、“我创建的问卷”中展示问卷简介或缩略图。
	 * */
	public List<questionnaire> getQuesListCreated(int userId);
	
	
	/*
	 * questionnaire getQuesContent(int id);
	 * 参数：questionnaire.id
	 * 返回：对应的questionnaire实例
	 * 说明：需要查找questionnaire，one_question，q_options三张表，并且questionnaire的
	 *       questions属性需要包含问卷对应的所有题目构成的List，同理questions的options
	 *       属性需要包含question对应的所有选项构成的List。用于预览、编辑、填写问卷。
	 * */
	public questionnaire getQuesContent(int id);
	
	
	/*
	 * int saveQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：保存状态（成功返回所创建的questionnaire实例id，失败返回-1）
	 * 说明：参数是questionnaire实例，其中包含questions列表，每个questions包含options列
	 *       表需要保存时分别存储到对应的table并且保证相互关联。用于保存问卷。
	 * */
	public int saveQuesContent(questionnaire ques);
	
	
	/*
	 * int updateQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：更新状态（成功返回0，失败返回-1）
	 * 说明：参数是questionnaire实例，其中包含questions列表，每个questions包含options列
	 *       表需要保存时分别存储到对应的table并且保证相互关联。用于修改问卷。
	 * */
	public int updateQuesContent(questionnaire ques);
	
	
	/*
	 * int deleteQuesContent(questionnaire ques);
	 * 参数：questionnaire实例
	 * 返回：删除状态，成功则返回0，失败返回-1
	 * 说明：参数中questionnaire不需要为完整的questionnaire实例，甚至可以只拥有
	 *       questionnaire的id（为了接口统一所以封装成questionnaire）。只需要在
	 *       questionnaire表中删除，其余由数据库CASCADE约束实现。用于删除问卷。
	 * */
	int deleteQuesContent(questionnaire ques);
	
	
	/*
	 * user getUserInfo(int id);
	 * 参数：用户id
	 * 返回：对应的user实例
	 * 说明：根据用户id查找用户并返回。用于用户浏览用户信息。
	 * */
	public user getUserInfo(int id);
	
	
	/*
	 * int updateUserInfo(user user);
	 * 参数：user实例
	 * 返回：更新状态（成功返回0，失败返回-1）
	 * 说明：更新用户信息，不需要重新创建。用于用户修改用户信息。
	 * */
	public int updateUserInfo(user user);
	
	
	/* 问卷填写模块的service需要修改model层，先不实现  */
	
	/*
	 * List<answer_questionnaire> getQuesListFilled(int userId)
	 * 参数：用户id
	 * 返回：用户所填写的所有questionnaire构成的List
	 * 说明：从answer_questionnaire和questionnaire中查找，List中存储的可以是不完整的
	 *       questionnaire的实例，即questionnaire的questions属性应该为null。用于在前
	 *       端“我填写的问卷”中展示问卷简介或缩略图。
	 * */
	public List<questionnaire> getQuesListFilled(int userId);
	
}
