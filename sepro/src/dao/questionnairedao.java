/******************************************************************
 * 7.4 添加方法getQuesListByUser（根据userID查找问卷）
 * 7.18添加方法getAllQuesList（得到所有已发布问卷）
 ******************************************************************/
package dao;

import java.util.List;

import model.questionnaire;

public interface questionnairedao {
	
		//查找问卷
		public questionnaire getq(int id);
		
		//新建问卷
		public int setq(questionnaire q);
		
		//问卷修改
		public boolean updateq(questionnaire q);
		
		//问卷删除
		public boolean deleteq(int id);
		
		//根据userId查找问卷
		public List<questionnaire> getQuesListByUser(int userId);
		
		//得到所有已发布问卷
		public List<questionnaire> getAllQuesList();
}
