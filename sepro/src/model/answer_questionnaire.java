/*******************************************************************
 *  7.4 添加属性questionnaire，为用户所回答的问卷的内容,ansList为用户的答案构
 *      成的List
 *      实现Serializable的hashCode()和equal()接口，使用hibernate复合主键映射
 * 7.12 submit_time的类型java.sql.Time->java.util.Date,修改数据库和.hbm.xml
 *******************************************************************/

package model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import model.questionnaire;
import model.answers;


public class answer_questionnaire implements Serializable {
    
	private static final long serialVersionUID = -8415608564627901341L;
	
	private int u_id;
	private int q_id;
	private Date submit_time;
	private int if_complete;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	
	public Date getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}
	
	public int getIf_complete() {
		return if_complete;
	}
	public void setIf_complete(int if_complete) {
		this.if_complete = if_complete;
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(u_id).hashCode() + Integer.valueOf(q_id).hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		answer_questionnaire ans_ques = (answer_questionnaire) obj;
		if((u_id == ans_ques.getU_id()) && (q_id == ans_ques.getQ_id())){
			return true;
		} else {
			return false;
		}
	}

	/* 问卷题目内容   */
	private questionnaire questionnaire = new questionnaire();
	
	@Transient
	public questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	/* 用户答案   */
	private List<answers>ansList = new ArrayList<answers>();
	
	@Transient
	public List<answers> getAnsList() {
		return ansList;
	}
	public void setAnsList(List<answers> ansList) {
		this.ansList = ansList;
	}

}
