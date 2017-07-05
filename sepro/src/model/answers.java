/*******************************************************************
 *  7.4 实现Serializable的hashCode()和equal()接口，使用hibernate复合主键映射
 *******************************************************************/

package model;

import java.io.Serializable;


public class answers implements Serializable {
 
	private static final long serialVersionUID = 8663594119607142231L;
	
	private int u_id;
	private int o_id;
	private String answer;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(u_id).hashCode() + Integer.valueOf(o_id).hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		answers ans = (answers) obj;
		if (this.o_id == ans.getO_id() && this.u_id == ans.getU_id()){
			return true;
		} else {
			return false;
		}
	}
	
}
