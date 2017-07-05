package dao;
 
import model.q_options;
public interface q_optiondao {
	 public  q_options getqo(int q_id, String title);//获得一个问题
	 public boolean delqo(int q_id, String title);//删除一个问题
	 public boolean updateqo(q_options qo);//修改一个问题
	 public boolean setqo(q_options qo);//创建一个问题
}
