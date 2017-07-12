/******************************************************************
 * 6.30 修改char->String
 *      修改拼写questionier->questionnaire，更改所有引用
 *      添加变量set_time，end_time：根据数据库设计修改
 * 7.3  增加成员 List<one_question>questions, 表示一个questionnaire对
 *      应的所有question
  * 7.4 修改List->Set，使用hibernate一对多映射
 *****************************************************************/

package model;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

import model.one_question;

public class questionnaire {
	
		private int id;
		private int u_id;//
		private String title; //标题
		private String instruction; //问卷说明
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
