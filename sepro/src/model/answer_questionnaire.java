/*******************************************************************
 *  7.4 �������questionnaire��Ϊ�û����ش���ʾ������,ansListΪ�û��Ĵ𰸹�
 *      �ɵ�List
 *      ʵ��Serializable��hashCode()��equal()�ӿڣ�ʹ��hibernate��������ӳ��
 *******************************************************************/

package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

import model.questionnaire;
import model.answers;


public class answer_questionnaire implements Serializable {
    
	private static final long serialVersionUID = -8415608564627901341L;
	
	private int u_id;
	private int q_id;
	private Time submit_time;
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
	
	public Time getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Time submit_time) {
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

	/* �ʾ���Ŀ����   */
	private questionnaire questionnaire = new questionnaire();
	
	public questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	/* �û���   */
	private List<answers>ansList = new ArrayList<answers>();
	
	public List<answers> getAnsList() {
		return ansList;
	}
	public void setAnsList(List<answers> ansList) {
		this.ansList = ansList;
	}

}
