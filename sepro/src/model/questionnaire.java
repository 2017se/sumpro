/******************************************************************
 * 6.30 �޸�char->String
 *      �޸�ƴдquestionier->questionnaire��������������
 *      ��ӱ���set_time��end_time���������ݿ�����޸�
 * 7.3  ���ӳ�Ա List<one_question>questions, ��ʾһ��questionnaire��
 *      Ӧ������question
  * 7.4 �޸�List->Set��ʹ��hibernateһ�Զ�ӳ��
 *****************************************************************/

package model;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

import model.one_question;

public class questionnaire {
	
		private int id;
		private int u_id;//
		private String title; //����
		private String instruction; //�ʾ�˵��
		private Date set_date;
		private Date end_date;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getInstruction() {
			return instruction;
		}
		public void setInstruction(String instruction) {
			this.instruction = instruction;
		}
		
		public Date getSet_date() {
			return set_date;
		}
		public void setSet_date(Date set_date) {
			this.set_date = set_date;
		}
		
		public Date getEnd_date() {
			return end_date;
		}
		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		}
		
		/*questions: questions of a questionnaire*/
		private Set<one_question> questions = new HashSet<one_question>();
		
		public Set<one_question> getQuestions() {
			return questions;
		}
		
		public void setQuestions(Set<one_question> questions) {
			this.questions = questions;
		}

}
