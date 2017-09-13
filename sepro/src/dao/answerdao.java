/********************************************************************
 * 9.12 添加getAnsListByQuesId，用于导出单个问题的所有答案
 ********************************************************************/
package dao;
import java.util.List;

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
		
		//得到单个问题的所有回答
		public List<answers> getAnsListByQuesId(int questionId);
		
}
