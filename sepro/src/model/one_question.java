/******************************************************************
 * 6.30 �޸�char->String
 *      �������ݿ������д
 * 7.3  ���ӳ�Ա List<q_options> Options, ��ʾһ��question��Ӧ������
 *      ѡ��
 * 7.4 �޸�List->Set��ʹ��hibernateһ�Զ�ӳ��
 *****************************************************************/

package model;

import model.q_options;

import java.util.HashSet;
import java.util.Set;

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

	
	private Set<q_options> options = new HashSet<q_options>();
	
	public Set<q_options> getOptions() {
		return options;
	}
	
	public void setOptions(Set<q_options> options) {
		this.options = options;
	}

}
