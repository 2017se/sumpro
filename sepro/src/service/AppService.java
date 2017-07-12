/********************************************************************************
 * 7.3 ���崴���޸�ɾ���ʾ��޸��û���Ϣ��Ҫ��service��ӿ�
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
	 * ��¼ 
	 * ����1������username��email��phone������2������
	 * ���ƥ��ɹ������ظ�user���û������ڻ����벻��ȷ����null
	 * */
	public user login(String username, String password);
	
	
	/**
	 * ע��
	 * ������user,��action��ʱ������user���󣬰���username��phone��password
	 * �û����Ѵ��ڷ���-1��phone�Ѵ��ڷ���-2
	 * �û������Ϸ�����-3��phone���Ϸ�����-4�����벻�Ϸ�����-5(�ж��Ƿ�Ϸ������Ȳ�ʵ�֣�
	 * ע��ɹ�����1
	 * */
	public int register(user user);
	
	
	/**
	 * List<questionnaire> getQuesListCreated(int userId)
	 * �������û�id
	 * ���أ��û�������������questionnaire���ɵ�List
	 * ˵����������ǰ�ˡ��ʾ�㳡�������Ҵ������ʾ���չʾ�ʾ��������ͼ��
	 * */
	public List<questionnaire> getQuesListCreated(int userId);
	
	
	/**
	 * questionnaire getQuesContent(int id);
	 * ������questionnaire.id
	 * ���أ���Ӧ��questionnaireʵ��
	 * ˵������Ҫ����questionnaire��one_question��q_options���ű�����questionnaire��
	 *       questions������Ҫ�����ʾ��Ӧ��������Ŀ���ɵ�List��ͬ��questions��options
	 *       ������Ҫ����question��Ӧ������ѡ��ɵ�List��������hibernateһ�Զ�ӳ��ʵ�֡�����
	 *       Ԥ�����༭����д�ʾ�
	 * */
	public questionnaire getQuesContent(int id);
	
	
	/**
	 * int saveQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�����״̬���ɹ�������������questionnaireʵ��id��ʧ�ܷ���-1��
	 * ˵����������questionnaireʵ�������а���questions�б�ÿ��questions����options��
	 *       ������questionnaire��id��one_question��id��q_id���Լ�q_options��q_id����Ҫ
	 *       ָ��������ʱ�ֱ�洢����Ӧ��table���ұ�֤�໥���������ڱ����ʾ�
	 * */
	public int saveQuesContent(questionnaire ques);
	
	
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
	public int updateQuesContent(questionnaire ques);
	
	
	/**
	 * int deleteQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�ɾ��״̬���ɹ��򷵻�0��ʧ�ܷ���-1
	 * ˵����������questionnaire����ҪΪ������questionnaireʵ������������ֻӵ��
	 *       questionnaire��id��Ϊ�˽ӿ�ͳһ���Է�װ��questionnaire����ֻ��Ҫ��
	 *       questionnaire����ɾ�������������ݿ�CASCADEԼ��ʵ�֡�����ɾ���ʾ�
	 * */
	public int deleteQuesContent(questionnaire ques);
	
	
	/**
	 * user getUserInfo(int id);
	 * �������û�id
	 * ���أ���Ӧ��userʵ����ʧ�ܷ���null
	 * ˵���������û�id�����û������ء������û�����û���Ϣ��
	 * */
	public user getUserInfo(int id);
	
	
	/**
	 * int updateUserInfo(user user);
	 * ������userʵ��
	 * ���أ�����״̬���ɹ�����0��ʧ�ܷ���-1��
	 * ˵���������û���Ϣ������Ҫ���´����������û��޸��û���Ϣ��
	 * */
	public int updateUserInfo(user user);
	
	
	/**
	 * List<answer_questionnaire> getQuesListFilled(int userId)
	 * �������û�id
	 * ���أ��û�����д������answer_questionnaire���ɵ�List
	 * ˵������answer_questionnaire��questionnaire�в��ң�List�д洢��Ӧ����������
	 *       answer_questionnaire��ʵ������answer_questionnaire��questionnaire����
	 *       ��Ҫ��Ϊnull��������Ҫ������Ŀ��ѡ������ݣ���answer_questionnaire��
	 *       questionnaire���Կ���Ϊ��������ʵ����������ǰ�ˡ�����д���ʾ���չʾ�ʾ�
	 *       ��������ͼ��
	 * */
	public List<answer_questionnaire> getQuesListFilled(int userId);
	
	
	/**
	 * answer_questionnaire getQuesContentFilled(int userId,int quesId);
	 * �������ʾ���д��userʵ����id���ʾ�questionnaireʵ����id
	 * ���أ�������answer_questionnaireʵ��
	 * ˵��������������answer_questionnaireʵ��������questionnaire��ansList���Բ�����
	 *       Ϊ�գ���questionnaireʵ���е�questions���Լ�one_questionʵ����options��
	 *       �Ծ�������Ϊ�ա������û��������д���ʾ�
	 * */
	public answer_questionnaire getQuesContentFilled(int userId,int quesId);
	
	
	/**
	 * int saveAnswerList(List<answers> ansList);
	 * <p>��������answerʵ�����ɵ�ansList�б�
	 * <p>˵����<b>���ansList��ĳ��ʵ����answers�����Ѿ����ڣ�����¸�����¼�����û���򴴽�
	 *      answersʵ��������<u>��������</u>�û��Ĵ𰸡�<u>������action��ֱ�ӵ��á�</u>
	 * */
	public void saveAnswerList(List<answers> ansList);
	
	
	/**
	 * int saveAnsQuesRecord(answer_questionnaire ansQuesRecord);
	 * <p>������answer_questionnaireʵ��
	 * <p>˵����<b>���������ǲ�������answer_questionnaireʵ������ֻ��Ҫӵ��q_id��u_id��
	 *      submit_time��if_complete���ԣ�����Ҫ��ansList���Բ�Ϊ�ա�questionnaire
	 *      ���Բ���Ҫ��ansList�о����answers���������saveAnswerList()�������档
	 *      ����<u>��������</u>�û���д�ʾ�����ݡ�
	 * */
	 public void saveAnsQuesContent(answer_questionnaire ansQuesRecord);
	 
	 
	/**
	 * void updateOptionSet(Set<q_options> optionSet, int quesId);
	 * <p>˵����<b>����Service��updateQuesContent()������ʵ�֣�action�㲻������øýӿڡ�
	 * @param optionSet ��Ҫ���µ�one_questionʵ��������options���ɵ�Set
	 * @param quesId one_questionʵ����id
	 * */
	public void updateOptionSet(Set<q_options> optionSet, int quesId);
	
	
	/**
	 * int saveQuestionnaire(questionnaire ques);
	 * <p>������questionnaireʵ��
	 * <p>���أ����浽���ݿ�֮�󷵻ص�questionnaire.id
	 * <p>˵���������ǲ�������questionnaireʵ��������Ҫӵ��id��questions���Կ���Ϊ�ա�����
	 *         �����½����ʾ�
	 * **/
	public int saveQuestionnaire(questionnaire ques);
	
	
	/**
	 * int saveQuestion(one_question one_ques);
	 * <p>������one_questionʵ��
	 * <p>���أ����浽���ݿ�֮�󷵻ص�one_question.id
	 * <p>˵��������Ϊ��������one_questionʵ��������Ҫ����id��options���Կ���Ϊ�ա�������
	 *         Ҫָ����Ӧ��questionnaire��id��q_id���ԡ����ڱ����½��ʾ��е���Ŀ��
	 * **/
	public int saveQuestion(one_question one_ques);
	
	/**
	 * void saveOption(q_options opt);
	 * <p>������q_optionsʵ��
	 * <p>˵����q_optionsû�����õ���������������Ҫ����ֵ�����ڱ����½��ʾ��е�ѡ�
	 * **/
	public void saveOption(q_options opt);
	
}
