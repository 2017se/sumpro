/******************************************************************
 * 6.30 修改char->String
 *      根据数据库设计重写
 *****************************************************************/

package model;

public class one_question {
	
	private int id;
	private int q_id;
	private int title_num;
	private String stem;
	private int type;
	private int nessecity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	
	public int getTitle_num() {
		return title_num;
	}
	public void setTitle_num(int title_num) {
		this.title_num = title_num;
	}
	
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getNessecity() {
		return nessecity;
	}
	public void setNessecity(int nessecity) {
		this.nessecity = nessecity;
	}

}
