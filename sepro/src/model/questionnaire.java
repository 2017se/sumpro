/******************************************************************
 * 6.30 �޸�char->String
 *      �޸�ƴдquestionier->questionnaire��������������
 *      ��ӱ���set_time��end_time���������ݿ�����޸�
 * 7.3  ���ӳ�Ա List<one_question>questions, ��ʾһ��questionnaire��
 *      Ӧ������question
 *****************************************************************/

package model;

import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

import model.one_question;

public class questionnaire {
	
		private int id;
		private int u_id;//
		private String title; //����
		private String instruction; //�ʾ�˵��
		private Time set_time;
		private Time end_time;
		
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
		
		public Time getSet_time() {
			return set_time;
		}
		public void setSet_time(Time set_time) {
			this.set_time = set_time;
		}
		
		public Time getEnd_time() {
			return end_time;
		}
		public void setEnd_time(Time end_time) {
			this.end_time = end_time;
		}
		
		/*questions: questions of a questionnaire*/
		private List<one_question> questions = new ArrayList<one_question>();
		
		public List<one_question> getQuestions() {
			return questions;
		}
		
		public void setQuestions(List<one_question> questions) {
			this.questions = questions;
		}

}
