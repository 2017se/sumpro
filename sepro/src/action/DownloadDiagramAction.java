package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import service.AppService;

public class DownloadDiagramAction extends BaseAction{

	private static final long serialVersionUID = 4245783058238517207L;
	
	private int questionId;
	
	private String fileName;
	
	private InputStream fileInputStream;
	
	private AppService appService;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	} 
	
	public String getImg() throws Exception{
		fileName = "diagram_" + questionId + ".jpg";
		String filePath = appService.getDataDiagram(questionId);
		File file = new File(filePath);
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
