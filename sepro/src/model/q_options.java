/******************************************************************
 * 6.30 修改char->String
  * 7.4 实现Serializable的hashCode()和equal()接口，使用hibernate复合主键映射
 *****************************************************************/

package model;

import java.io.Serializable;


public class q_options implements Serializable{

	private static final long serialVersionUID = -4045380240026686625L;
	
	private int q_id;
	private String title;
	private String property;
		
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
		
	@Override
	public int hashCode(){
		return Integer.valueOf(q_id).hashCode() + title.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		q_options opt = (q_options) obj;
		if (q_id != opt.getQ_id()) {
			return false;
		} else if(this.title.equals(opt.getTitle())) {
			return true;
		}
		return false;
	}
	
}
