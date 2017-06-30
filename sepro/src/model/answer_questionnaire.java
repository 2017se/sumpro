package model;

import java.sql.Time;

public class answer_questionnaire {
    
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
	
}
