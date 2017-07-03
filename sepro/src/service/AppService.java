/********************************************************************************
 * 7.3 ���崴���޸�ɾ���ʾ��޸��û���Ϣ��Ҫ��service��ӿ�
 *******************************************************************************/

package service;

import java.util.List;

import model.user;
import model.questionnaire;

public interface AppService {

	
	/* 
	 * ��¼ 
	 * ����1������username��email��phone������2������
	 * ���ƥ��ɹ������ظ�user���û������ڻ����벻��ȷ����null
	 * */
	public user login(String username, String password);
	
	
	/*
	 * ע��
	 * ������user,��action��ʱ������user���󣬰���username��phone��password
	 * �û����Ѵ��ڷ���-1��phone�Ѵ��ڷ���-2
	 * �û������Ϸ�����-3��phone���Ϸ�����-4�����벻�Ϸ�����-5(�ж��Ƿ�Ϸ������Ȳ�ʵ�֣�
	 * ע��ɹ�����1
	 * */
	public int register(user user);
	
	
	/*
	 * List<questionnaire> getQuesListCreated(int userId)
	 * �������û�id
	 * ���أ��û�������������questionnaire���ɵ�List
	 * ˵����ֻ��questionnaireһ�ű��в��Ҽ��ɣ�questionnaire��questions����Ӧ��Ϊnull��
	 *       ������ǰ�ˡ��ʾ�㳡�������Ҵ������ʾ���չʾ�ʾ��������ͼ��
	 * */
	public List<questionnaire> getQuesListCreated(int userId);
	
	
	/*
	 * questionnaire getQuesContent(int id);
	 * ������questionnaire.id
	 * ���أ���Ӧ��questionnaireʵ��
	 * ˵������Ҫ����questionnaire��one_question��q_options���ű�����questionnaire��
	 *       questions������Ҫ�����ʾ��Ӧ��������Ŀ���ɵ�List��ͬ��questions��options
	 *       ������Ҫ����question��Ӧ������ѡ��ɵ�List������Ԥ�����༭����д�ʾ�
	 * */
	public questionnaire getQuesContent(int id);
	
	
	/*
	 * int saveQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�����״̬���ɹ�������������questionnaireʵ��id��ʧ�ܷ���-1��
	 * ˵����������questionnaireʵ�������а���questions�б�ÿ��questions����options��
	 *       ����Ҫ����ʱ�ֱ�洢����Ӧ��table���ұ�֤�໥���������ڱ����ʾ�
	 * */
	public int saveQuesContent(questionnaire ques);
	
	
	/*
	 * int updateQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�����״̬���ɹ�����0��ʧ�ܷ���-1��
	 * ˵����������questionnaireʵ�������а���questions�б�ÿ��questions����options��
	 *       ����Ҫ����ʱ�ֱ�洢����Ӧ��table���ұ�֤�໥�����������޸��ʾ�
	 * */
	public int updateQuesContent(questionnaire ques);
	
	
	/*
	 * int deleteQuesContent(questionnaire ques);
	 * ������questionnaireʵ��
	 * ���أ�ɾ��״̬���ɹ��򷵻�0��ʧ�ܷ���-1
	 * ˵����������questionnaire����ҪΪ������questionnaireʵ������������ֻӵ��
	 *       questionnaire��id��Ϊ�˽ӿ�ͳһ���Է�װ��questionnaire����ֻ��Ҫ��
	 *       questionnaire����ɾ�������������ݿ�CASCADEԼ��ʵ�֡�����ɾ���ʾ�
	 * */
	int deleteQuesContent(questionnaire ques);
	
	
	/*
	 * user getUserInfo(int id);
	 * �������û�id
	 * ���أ���Ӧ��userʵ��
	 * ˵���������û�id�����û������ء������û�����û���Ϣ��
	 * */
	public user getUserInfo(int id);
	
	
	/*
	 * int updateUserInfo(user user);
	 * ������userʵ��
	 * ���أ�����״̬���ɹ�����0��ʧ�ܷ���-1��
	 * ˵���������û���Ϣ������Ҫ���´����������û��޸��û���Ϣ��
	 * */
	public int updateUserInfo(user user);
	
	
	/* �ʾ���дģ���service��Ҫ�޸�model�㣬�Ȳ�ʵ��  */
	
	/*
	 * List<answer_questionnaire> getQuesListFilled(int userId)
	 * �������û�id
	 * ���أ��û�����д������questionnaire���ɵ�List
	 * ˵������answer_questionnaire��questionnaire�в��ң�List�д洢�Ŀ����ǲ�������
	 *       questionnaire��ʵ������questionnaire��questions����Ӧ��Ϊnull��������ǰ
	 *       �ˡ�����д���ʾ���չʾ�ʾ��������ͼ��
	 * */
	public List<questionnaire> getQuesListFilled(int userId);
	
}
