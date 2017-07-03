/******************************************************************
 * 6.30 修改char->String
 *      根据数据库设计重写
 * 7.3  增加成员 List<q_options> Options, 表示一个question对应的所有
 *      选项
 *****************************************************************/

package model;

import model.q_options;

import java.util.ArrayList;
import java.util.List;

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

	
	private List<q_options> options = new ArrayList<q_options>();
	
	public List<q_options> getOptions() {
		return options;
	}
	
	public void setOptions(List<q_options> options) {
		this.options = options;
	}

}
