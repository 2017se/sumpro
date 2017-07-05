package dao;

import model.questionnaire;

public interface questionnairedao {
		//问卷删除
		public questionnaire getq(int id);
		//新建问卷
		public boolean setq(questionnaire q);
		//问卷修改
		public boolean updateq(questionnaire q);
		//问卷删除
		public boolean deleteq(int id);
}
