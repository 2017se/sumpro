package dao;
import model.questionier;
public interface questionierdao {
		//问卷删除
		public questionier getq(int id);
		//新建问卷
		public boolean setq(questionier q);
		//问卷修改
		public boolean updateq(questionier q);
		//问卷删除
		public boolean deleteq(int id);
}
