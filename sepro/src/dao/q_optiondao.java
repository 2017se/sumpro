package dao;
 
import model.q_options;
public interface q_optiondao {
	 public  q_options getqo(int q_id);//���һ������
	 public boolean delqo(int q_id);//ɾ��һ������
	 public boolean updateqo(q_options qo);//�޸�һ������
	 public boolean setqo(q_options qo);//����һ������
}
