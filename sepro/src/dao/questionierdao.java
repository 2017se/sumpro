package dao;
import model.questionier;
public interface questionierdao {
		//�ʾ�ɾ��
		public questionier getq(int id);
		//�½��ʾ�
		public boolean setq(questionier q);
		//�ʾ��޸�
		public boolean updateq(questionier q);
		//�ʾ�ɾ��
		public boolean deleteq(int id);
}
