package dao;
import model.answers;
public interface answerdao {
		//获得answer
		public answers getan(int o_id,int u_id);
		//回答一个问题
		public boolean setan(answers an);
		//删除一个答案
		public boolean deletean(int o_id,int u_id);
		//更改一个答案
		public boolean updatean(answers an);
		
}
